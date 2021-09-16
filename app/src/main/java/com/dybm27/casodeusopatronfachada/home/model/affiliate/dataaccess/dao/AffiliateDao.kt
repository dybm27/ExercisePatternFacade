package com.dybm27.casodeusopatronfachada.home.model.affiliate.dataaccess.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dybm27.casodeusopatronfachada.home.model.affiliate.dataaccess.entities.AffiliateEntity

@Dao
interface AffiliateDao {
    @Query("select * from affiliate where cc = :cc")
    fun getAffiliate(cc: String): AffiliateEntity?

    @Insert
    fun addAffiliate(vararg affiliateEntity: AffiliateEntity)
}