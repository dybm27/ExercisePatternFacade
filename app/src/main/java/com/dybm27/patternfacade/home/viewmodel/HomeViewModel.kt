package com.dybm27.patternfacade.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dybm27.patternfacade.home.model.IHospitalFacade
import com.dybm27.patternfacade.home.view.data.DataSelect
import com.dybm27.patternfacade.home.view.data.Specialist
import com.dybm27.patternfacade.home.view.data.TypeSpecialist
import com.dybm27.patternfacade.util.ResultApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hospitalFacade: IHospitalFacade
) : ViewModel() {

    private val _dataSelects = MutableLiveData<ResultApi<DataSelect>>()
    val dataSelects get() = _dataSelects
    private val _message = MutableLiveData<ResultApi<String>>()
    val message get() = _message

    init {
        getDataSelects()
    }

    private fun getDataSelects() =
        viewModelScope.launch {
            hospitalFacade.getDataSelects().collect {
                _dataSelects.postValue(it)
            }
        }


    fun registerSpecialistAppointment(
        date: Date,
        typeSpecialist: TypeSpecialist,
        specialist: Specialist,
        cc: String
    ) =
        viewModelScope.launch {
            hospitalFacade.registerSpecialistAppointment(date, typeSpecialist, specialist, cc)
                .collect {
                    _message.postValue(it)
                }
        }
}