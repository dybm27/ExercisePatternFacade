package com.dybm27.patternfacade.home.model.appointment

import java.util.*

interface IAppointmentRepository {
    fun validateExistingAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    )

    suspend fun registerAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    ): String

    suspend fun validateDate(date: Date)
}