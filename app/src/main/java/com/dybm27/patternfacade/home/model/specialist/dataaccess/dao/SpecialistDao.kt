package com.dybm27.patternfacade.home.model.specialist.dataaccess.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.ScheduleEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface SpecialistDao {
    @Query("select * from type_specialist")
    fun getTypeSpecialists(): Flow<List<TypeSpecialistEntity>>

    @Query("select * from specialist")
    fun getSpecialists(): Flow<List<SpecialistEntity>>

    @Query("select * from schedule where id_specialist = :idSpecialist and date = :date")
    fun getScheduleByDate(idSpecialist: Long, date: Date): ScheduleEntity?

    @Insert
    suspend fun addSchedule(vararg schedule: ScheduleEntity)
}