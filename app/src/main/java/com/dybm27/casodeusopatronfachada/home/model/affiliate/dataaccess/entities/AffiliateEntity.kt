package com.dybm27.casodeusopatronfachada.home.model.affiliate.dataaccess.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "affiliate")
data class AffiliateEntity(
    @PrimaryKey val cc: String,
    val name: String
)
