package com.dybm27.patternfacade.home.model.specialist

import com.dybm27.patternfacade.home.model.specialist.dataaccess.dao.SpecialistDao
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.ScheduleEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class SpecialistRepository @Inject constructor(
    private val specialistDao: SpecialistDao
) : ISpecialistRepository {
    override fun getTypeSpecialist(): Flow<List<TypeSpecialistEntity>> =
        specialistDao.getTypeSpecialists()

    override fun getSpecialist(): Flow<List<SpecialistEntity>> =
        specialistDao.getSpecialists()

    override fun validateTheAvailabilityOfTheSpecialist(
        idSpecialist: Long,
        date: Date
    ): Boolean = specialistDao.getScheduleByDate(idSpecialist, date) != null

    override suspend fun addAppointment(idSpecialist: Long, date: Date) =
        specialistDao.addSchedule(ScheduleEntity(idSpecialist = idSpecialist, date = date))
}