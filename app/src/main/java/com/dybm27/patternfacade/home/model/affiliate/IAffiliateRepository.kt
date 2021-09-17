package com.dybm27.patternfacade.home.model.affiliate

interface IAffiliateRepository {
    fun validateAffiliation(cc: String): Boolean
}