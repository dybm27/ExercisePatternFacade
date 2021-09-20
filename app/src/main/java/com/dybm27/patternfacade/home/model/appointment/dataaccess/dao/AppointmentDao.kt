package com.dybm27.patternfacade.home.model.appointment.dataaccess.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dybm27.patternfacade.home.model.appointment.dataaccess.entities.AppointmentEntity
import java.util.*

@Dao
interface AppointmentDao {

    @Query("select * from appointment where cc_affiliate = :cc and date = :date and id_specialist=:idSpecialist and id_type = :idType")
    fun getAppointment(cc: String, date: Date, idSpecialist: Long, idType: Long): AppointmentEntity?

    @Insert
    suspend fun addAppointment(vararg appointment: AppointmentEntity)
}