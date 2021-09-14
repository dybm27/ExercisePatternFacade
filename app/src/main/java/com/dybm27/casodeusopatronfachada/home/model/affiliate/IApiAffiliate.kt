package com.dybm27.casodeusopatronfachada.home.model.affiliate

interface IApiAffiliate {
    fun validateAffiliation(cc: String): Boolean
}