package com.dybm27.patternfacade.home.model.appointment.dataaccess

import java.util.*

interface IApiAppointment {
    fun validateExistingAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    ): Boolean

    fun registerAppointment(cc: String, date: Date, idSpecialist: Long, idType: Long)
}