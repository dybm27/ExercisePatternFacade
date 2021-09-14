package com.dybm27.casodeusopatronfachada.home.model.appointment.dataaccess

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