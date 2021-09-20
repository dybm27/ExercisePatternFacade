package com.dybm27.patternfacade.home.model.specialist

import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import kotlinx.coroutines.flow.Flow
import java.util.*

interface ISpecialistRepository {
    fun getTypeSpecialist(): Flow<List<TypeSpecialistEntity>>
    fun getSpecialist(): Flow<List<SpecialistEntity>>
    fun validateTheAvailabilityOfTheSpecialist(
        idSpecialist: Long,
        date: Date
    ): Boolean

    suspend fun addAppointment(
        idSpecialist: Long,
        date: Date
    )
}