package com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "schedule")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "id_specialist") val idSpecialist: Long,
    val date: Date
)
