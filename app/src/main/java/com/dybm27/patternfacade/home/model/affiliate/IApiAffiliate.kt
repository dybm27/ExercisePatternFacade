package com.dybm27.patternfacade.home.model.affiliate

interface IApiAffiliate {
    fun validateAffiliation(cc: String): Boolean
}