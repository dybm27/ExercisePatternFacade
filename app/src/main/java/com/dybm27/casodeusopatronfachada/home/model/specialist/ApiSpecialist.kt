package com.dybm27.casodeusopatronfachada.home.model.specialist

import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.dao.SpecialistDao
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.ScheduleEntity
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import java.util.*
import javax.inject.Inject

class ApiSpecialist @Inject constructor(
    private val specialistDao: SpecialistDao
) : IApiSpecialist {
    override fun getTypeSpecialist(): List<TypeSpecialistEntity> =
        specialistDao.getTypeSpecialists()

    override fun getSpecialist(): List<SpecialistEntity> =
        specialistDao.getSpecialists()

    override fun validateTheAvailabilityOfTheSpecialist(idSpecialist: Long, date: Date): Boolean {
        val schedule = specialistDao.getScheduleByDate(idSpecialist, date)
        if (schedule != null) {
            return true
        }
        return false
    }

    override fun addAppointment(idSpecialist: Long, date: Date) =
        specialistDao.addSchedule(ScheduleEntity(idSpecialist = idSpecialist, date = date))
}