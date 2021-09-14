package com.dybm27.casodeusopatronfachada.databuilder

import com.dybm27.casodeusopatronfachada.home.model.affiliate.dataaccess.entities.AffiliateEntity

class AffiliateTestDataBuilder {

    var cc = "123456789"
    var name = "Apolonia Fuente Palacio"

    fun withCc(cc: String): AffiliateTestDataBuilder {
        this.cc = cc
        return this
    }

    fun withName(name: String): AffiliateTestDataBuilder {
        this.name = name
        return this
    }

    fun build(): AffiliateEntity = AffiliateEntity(cc, name)
}