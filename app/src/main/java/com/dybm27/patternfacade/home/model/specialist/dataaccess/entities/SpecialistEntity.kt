package com.dybm27.patternfacade.home.model.specialist.dataaccess.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "specialist")
data class SpecialistEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    @ColumnInfo(name = "id_type") val idType: Long,
    @ColumnInfo(name = "phone_number") val phoneNumber: String
)
