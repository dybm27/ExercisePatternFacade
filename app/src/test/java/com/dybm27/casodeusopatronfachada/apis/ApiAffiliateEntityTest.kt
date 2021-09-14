package com.dybm27.casodeusopatronfachada.apis

import com.dybm27.casodeusopatronfachada.databuilder.AffiliateTestDataBuilder
import com.dybm27.casodeusopatronfachada.home.model.affiliate.ApiAffiliate
import com.dybm27.casodeusopatronfachada.home.model.affiliate.dataaccess.dao.AffiliateDao
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApiAffiliateEntityTest {

    private lateinit var apiAffiliate: ApiAffiliate

    @Mock
    private lateinit var affiliateDaoMock: AffiliateDao

    @Before
    fun init() {
        apiAffiliate = ApiAffiliate(affiliateDaoMock)
    }

    @Test
    fun validateAffiliation_ifYouAreAffiliated() {
        //Arrange
        val cc = "123456789"
        val affiliate = AffiliateTestDataBuilder().build()
        `when`(affiliateDaoMock.getAffiliate(cc))
            .thenReturn(affiliate)
        //Act
        val res = apiAffiliate.validateAffiliation(cc)
        //Assert
        assertTrue(res)
    }

    @Test
    fun validateAffiliation_youAreNotAffiliated() {
        //Arrange
        val cc = "123312312"
        `when`(affiliateDaoMock.getAffiliate(cc))
            .thenReturn(null)
        //Act
        val res = apiAffiliate.validateAffiliation(cc)
        //Assert
        assertFalse(res)
    }
}