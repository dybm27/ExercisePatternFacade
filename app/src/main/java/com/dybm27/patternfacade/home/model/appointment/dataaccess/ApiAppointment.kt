package com.dybm27.patternfacade.home.model.appointment.dataaccess

import com.dybm27.patternfacade.home.model.appointment.dataaccess.dao.AppointmentDao
import com.dybm27.patternfacade.home.model.appointment.dataaccess.entities.AppointmentEntity
import java.util.*
import javax.inject.Inject

class ApiAppointment @Inject constructor(private val appointmentDao: AppointmentDao) : IApiAppointment {
    override fun validateExistingAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    ): Boolean {
        val appointment = appointmentDao.getAppointment(cc, date, idSpecialist, idType)
        if (appointment != null) {
            return true
        }
        return false
    }

    override fun registerAppointment(cc: String, date: Date, idSpecialist: Long, idType: Long) =
        appointmentDao.addAppointment(
            AppointmentEntity(
                ccAffiliate = cc,
                date = date,
                idSpecialist = idSpecialist,
                idType = idType
            )
        )
}