package com.dybm27.patternfacade.home.model.specialist

import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import java.util.*

interface IApiSpecialist {
    fun getTypeSpecialist(): List<TypeSpecialistEntity>
    fun getSpecialist(): List<SpecialistEntity>
    fun validateTheAvailabilityOfTheSpecialist(
        idSpecialist: Long,
        date: Date
    ): Boolean
    fun addAppointment(
        idSpecialist: Long,
        date: Date
    )
}