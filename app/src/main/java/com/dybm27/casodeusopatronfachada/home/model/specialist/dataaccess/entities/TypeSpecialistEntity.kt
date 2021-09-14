package com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type_specialist")
data class TypeSpecialistEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)