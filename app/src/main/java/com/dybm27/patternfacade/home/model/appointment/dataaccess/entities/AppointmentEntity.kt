package com.dybm27.patternfacade.home.model.appointment.dataaccess.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "appointment")
data class AppointmentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "id_specialist") val idSpecialist: Long,
    @ColumnInfo(name = "cc_affiliate") val ccAffiliate: String,
    @ColumnInfo(name = "id_type") val idType: Long,
    val date: Date
)