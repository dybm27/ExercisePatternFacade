package com.dybm27.patternfacade.home.model.affiliate

import com.dybm27.patternfacade.home.model.ModelException
import com.dybm27.patternfacade.home.model.affiliate.dataaccess.dao.AffiliateDao
import javax.inject.Inject

class AffiliateRepositoryRepository @Inject constructor(private val affiliateDao: AffiliateDao) :
    IAffiliateRepository {

    override fun validateAffiliation(cc: String) {
        if (affiliateDao.getAffiliate(cc) != null)
            throw ModelException(ModelException.YOU_ARE_NOT_AFFILIATED)
    }

}