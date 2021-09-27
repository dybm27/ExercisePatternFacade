package com.dybm27.patternfacade.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dybm27.patternfacade.home.model.IHospitalFacade
import com.dybm27.patternfacade.home.view.data.DataScreenHome
import com.dybm27.patternfacade.home.view.data.DataSelects
import com.dybm27.patternfacade.home.view.data.Specialist
import com.dybm27.patternfacade.home.view.data.TypeSpecialist
import com.dybm27.patternfacade.util.Event
import com.dybm27.patternfacade.util.ResultApi
import com.dybm27.patternfacade.util.fromToModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hospitalFacade: IHospitalFacade
) : ViewModel() {

    private val _dataSelects = MutableLiveData<ResultApi<DataSelects>>()
    val dataSelects get() = _dataSelects
    private val _message = MutableLiveData<ResultApi<Event<String?>>>()
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


    fun registerSpecialistAppointment(data: DataScreenHome) =
        viewModelScope.launch {
            hospitalFacade.registerSpecialistAppointment(
                data.date, data.type.fromToModel(), data.specialist.fromToModel(), data.cc.value
            )
                .collect {
                    _message.postValue(ResultApi(it.status, Event(it.data), it.message))
                }
        }
}