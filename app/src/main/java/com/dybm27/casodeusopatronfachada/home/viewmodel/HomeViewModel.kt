package com.dybm27.casodeusopatronfachada.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dybm27.casodeusopatronfachada.home.model.IHospitalFacade
import com.dybm27.casodeusopatronfachada.home.view.data.Specialist
import com.dybm27.casodeusopatronfachada.home.view.data.TypeSpecialist
import com.dybm27.casodeusopatronfachada.util.ResultApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hospitalFacade: IHospitalFacade
) : ViewModel() {

    private val _types = MutableLiveData<ResultApi<List<TypeSpecialist>>>()
    val types = _types
    private val _specialist = MutableLiveData<ResultApi<List<Specialist>>>()
    val specialists = _specialist
    private val _message = MutableLiveData<ResultApi<String>>()
    val message = _message

    init {
        getDataSelects()
    }

    private fun getDataSelects() =
        viewModelScope.launch {
            hospitalFacade.getTypeSpecialists().collect {
                _types.postValue(it)
            }
            hospitalFacade.getSpecialists().collect {
                _specialist.postValue(it)
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