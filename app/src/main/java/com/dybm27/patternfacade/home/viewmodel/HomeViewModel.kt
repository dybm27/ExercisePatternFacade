package com.dybm27.patternfacade.home.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dybm27.patternfacade.home.model.IHospitalFacade
import com.dybm27.patternfacade.home.view.data.*
import com.dybm27.patternfacade.util.ResultApi
import com.dybm27.patternfacade.util.fromToModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hospitalFacade: IHospitalFacade
) : ViewModel() {

    private lateinit var dataSelects: DataSelects

    val types = mutableStateOf(listOf<String>())
    val specialists = mutableStateOf(listOf<String>())
    val isLoading = mutableStateOf(false)
    val dialog = mutableStateOf(OpenDialog())
    val data = mutableStateOf(DataScreenHome(cc = InputWrapper(minLength = 7, maxLength = 10)))
    private val calendar: Calendar = Calendar.getInstance()

    init {
        getDataSelects()
    }

    private fun getDataSelects() =
        viewModelScope.launch {
            hospitalFacade.getDataSelects().collect {
                when (it.status) {
                    ResultApi.Status.LOADING -> {
                        isLoading.value = true
                    }
                    ResultApi.Status.SUCCESS -> {
                        isLoading.value = false
                        it.data?.let { data ->
                            dataSelects = data
                            types.value = data.types.map { type -> type.name }
                        }
                    }
                }
            }
        }


    fun registerSpecialistAppointment() =
        viewModelScope.launch {
            if (!showMessageEmptyError()) {
                with(data.value) {
                    hospitalFacade.registerSpecialistAppointment(
                        date,
                        getTypeSpecialist(type.value).fromToModel(),
                        getSpecialist(specialist.value).fromToModel(),
                        cc.value
                    )
                        .collect {
                            when (it.status) {
                                ResultApi.Status.LOADING -> {
                                    isLoading.value = true
                                }
                                ResultApi.Status.SUCCESS -> {
                                    isLoading.value = false
                                    it.data?.let { message ->
                                        changeDataDialog(true, message)
                                    }
                                }
                            }
                        }
                }
            }
        }

    private fun getTypeSpecialist(name: String): TypeSpecialist =
        dataSelects.types.find { it.name == name }!!

    private fun getSpecialist(name: String): Specialist =
        dataSelects.specialist.find { it.name == name }!!

    private fun getListSpecialist(nameType: String) {
        val type = dataSelects.types.find { it.name == nameType }!!
        specialists.value = dataSelects.specialist.filter { it.idType == type.id }
            .map { it.name }
    }

    fun changeDataDialog(res: Boolean, message: String = "") {
        dialog.value = OpenDialog(res, message)
    }

    fun changeDataCc(text: String, message: String) {
        data.value = with(data.value) {
            this.copy(
                cc = this.cc.copy(
                    value = text,
                    error = text.count() in 1 until this.cc.minLength,
                    messageError = message
                )
            )
        }
    }

    fun changeDataName(text: String) {
        data.value = with(data.value) {
            this.copy(name = this.name.copy(value = text, error = false))
        }
    }

    fun changeDataType(text: String) {
        if (text != data.value.type.value) {
            data.value = with(data.value) {
                getListSpecialist(text)
                this.copy(
                    type = this.type.copy(value = text, error = text.isEmpty()),
                    specialist = InputWrapper()
                )
            }
        }
    }

    fun changeDataSpecialist(text: String) {
        data.value = with(data.value) {
            this.copy(specialist = this.specialist.copy(value = text, error = text.isEmpty()))
        }
    }

    fun changeDataDate(year: Int, month: Int, dayOfMonth: Int) {
        calendar.time = data.value.date
        calendar.set(year, month, dayOfMonth)
        data.value = with(data.value) {
            this.copy(date = calendar.time)
        }
    }

    fun changeDataTime(hour: Int, min: Int) {
        calendar.time = data.value.date
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, min)
        data.value = with(data.value) {
            this.copy(date = calendar.time)
        }
    }

    private fun showMessageEmptyError(): Boolean {
        data.value = with(data.value) {
            this.copy(
                type = this.type.copy(error = this.type.isEmpty()),
                specialist = this.specialist.copy(error = this.specialist.isEmpty()),
                cc = this.cc.copy(error = this.cc.isEmpty()),
                name = this.name.copy(error = this.name.isEmpty())
            )
        }
        return data.value.showMessageEmptyError()
    }
}