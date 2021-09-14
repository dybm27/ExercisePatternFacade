package com.dybm27.casodeusopatronfachada.home.model.affiliate

import com.dybm27.casodeusopatronfachada.home.model.affiliate.dataaccess.dao.AffiliateDao
import javax.inject.Inject

class ApiAffiliate @Inject constructor(private val affiliateDao: AffiliateDao) : IApiAffiliate {

    override fun validateAffiliation(cc: String): Boolean {
        val affiliate = affiliateDao.getAffiliate(cc)
        if (affiliate != null) {
            return true
        }
        return false
    }
}