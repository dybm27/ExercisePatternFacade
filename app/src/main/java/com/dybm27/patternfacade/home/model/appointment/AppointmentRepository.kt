package com.dybm27.patternfacade.home.model.appointment

import com.dybm27.patternfacade.home.model.appointment.dataaccess.dao.AppointmentDao
import com.dybm27.patternfacade.home.model.appointment.dataaccess.entities.AppointmentEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class AppointmentRepository @Inject constructor(private val appointmentDao: AppointmentDao) :
    IAppointmentRepository {
    override fun validateExistingAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    ): Boolean = appointmentDao.getAppointment(cc, date, idSpecialist, idType) != null


    override suspend fun registerAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    ) =
        appointmentDao.addAppointment(
            AppointmentEntity(
                ccAffiliate = cc,
                date = date,
                idSpecialist = idSpecialist,
                idType = idType
            )
        )
}