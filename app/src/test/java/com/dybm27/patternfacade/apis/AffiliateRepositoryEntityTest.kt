package com.dybm27.patternfacade.apis

import com.dybm27.patternfacade.databuilder.AffiliateTestDataBuilder
import com.dybm27.patternfacade.home.model.affiliate.AffiliateRepositoryRepository
import com.dybm27.patternfacade.home.model.affiliate.dataaccess.dao.AffiliateDao
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AffiliateRepositoryEntityTest {

    private lateinit var affiliateRepository: AffiliateRepositoryRepository

    @Mock
    private lateinit var affiliateDaoMock: AffiliateDao

    @Before
    fun init() {
        affiliateRepository = AffiliateRepositoryRepository(affiliateDaoMock)
    }

    @Test
    fun validateAffiliation_ifYouAreAffiliated() {
        //Arrange
        val cc = "123456789"
        val affiliate = AffiliateTestDataBuilder().build()
        `when`(affiliateDaoMock.getAffiliate(cc))
            .thenReturn(affiliate)
        //Act
        val res = affiliateRepository.validateAffiliation(cc)
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
        val res = affiliateRepository.validateAffiliation(cc)
        //Assert
        assertFalse(res)
    }
}