package com.dybm27.casodeusopatronfachada.home.model

import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import com.dybm27.casodeusopatronfachada.home.view.data.Specialist
import com.dybm27.casodeusopatronfachada.home.view.data.TypeSpecialist
import com.dybm27.casodeusopatronfachada.util.ResultApi
import kotlinx.coroutines.flow.Flow
import java.util.*


interface IHospitalFacade {
    suspend fun registerSpecialistAppointment(
        date: Date,
        typeSpecialist: TypeSpecialist,
        specialist: Specialist,
        cc: String
    ): Flow<ResultApi<String>>

    suspend fun getTypeSpecialists(): Flow<ResultApi<List<TypeSpecialist>>>
    suspend fun getSpecialists(): Flow<ResultApi<List<Specialist>>>
}