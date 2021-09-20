package com.dybm27.patternfacade.home.model

import com.dybm27.patternfacade.home.view.data.DataSelects
import com.dybm27.patternfacade.home.view.data.Specialist
import com.dybm27.patternfacade.home.view.data.TypeSpecialist
import com.dybm27.patternfacade.util.ResultApi
import kotlinx.coroutines.flow.Flow
import java.util.*


interface IHospitalFacade {
    suspend fun registerSpecialistAppointment(
        date: Date,
        typeSpecialist: TypeSpecialist,
        specialist: Specialist,
        cc: String
    ): Flow<ResultApi<String>>

    fun getDataSelects(): Flow<ResultApi<DataSelects>>
}