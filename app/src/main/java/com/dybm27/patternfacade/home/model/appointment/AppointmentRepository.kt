package com.dybm27.patternfacade.home.model.appointment

import com.dybm27.patternfacade.home.model.ModelException
import com.dybm27.patternfacade.home.model.appointment.dataaccess.dao.AppointmentDao
import com.dybm27.patternfacade.home.model.appointment.dataaccess.entities.AppointmentEntity
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AppointmentRepository @Inject constructor(private val appointmentDao: AppointmentDao) :
    IAppointmentRepository {
    private val calendar = Calendar.getInstance()
    override fun validateExistingAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    ) {
        if (appointmentDao.getAppointmentDate(cc, date) != null)
            throw ModelException(ModelException.THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_FOR_THIS_DATE)
        if (appointmentDao.getAppointmentSpecialist(
                cc = cc,
                idSpecialist = idSpecialist,
                idType = idType
            ) != null
        )
            throw ModelException(ModelException.THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_WITH_THE_SPECIALIST)
    }


    override suspend fun registerAppointment(
        cc: String,
        date: Date,
        idSpecialist: Long,
        idType: Long
    ): String {
        appointmentDao.addAppointment(
            AppointmentEntity(
                ccAffiliate = cc,
                date = date,
                idSpecialist = idSpecialist,
                idType = idType
            )
        )
        return ModelException.REGISTERED_APPOINTMENT
    }

    override suspend fun validateDate(date: Date) {
        calendar.time = date
        val hour = calendar.get(Calendar.HOUR)
        val min = calendar.get(Calendar.MINUTE)
        if (calendar.get(Calendar.DAY_OF_WEEK) !in 2..6) {
            throw ModelException(ModelException.INVALID_DATE)
        }
        val diff = date.time - Date().time
        if ((TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)) < 3) {
            throw ModelException(ModelException.INVALID_ANTICIPATION_DAYS)
        }
        when (calendar.get(Calendar.AM_PM)) {
            0 -> {
                if (hour !in 8..11) {
                    throw ModelException(ModelException.INVALID_TIME)
                }
            }
            1 -> {
                if (hour !in 2..5) {
                    throw ModelException(ModelException.INVALID_TIME)
                }
            }
        }
        if (validateMin(min)) {
            throw ModelException(ModelException.INVALID_TIME2)
        }
    }

    private fun validateMin(min: Int): Boolean = (min != 0 && min != 30)
}