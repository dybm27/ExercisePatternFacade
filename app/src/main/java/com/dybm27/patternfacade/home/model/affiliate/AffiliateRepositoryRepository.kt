package com.dybm27.patternfacade.home.model.affiliate

import com.dybm27.patternfacade.home.model.affiliate.dataaccess.dao.AffiliateDao
import javax.inject.Inject

class AffiliateRepositoryRepository @Inject constructor(private val affiliateDao: AffiliateDao) :
    IAffiliateRepository {

    override fun validateAffiliation(cc: String): Boolean = affiliateDao.getAffiliate(cc) != null

}