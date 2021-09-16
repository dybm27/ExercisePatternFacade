package com.dybm27.casodeusopatronfachada

import com.dybm27.casodeusopatronfachada.home.model.HospitalFacade
import com.dybm27.casodeusopatronfachada.home.model.affiliate.ApiAffiliate
import com.dybm27.casodeusopatronfachada.home.model.affiliate.IApiAffiliate
import com.dybm27.casodeusopatronfachada.home.model.appointment.dataaccess.IApiAppointment
import com.dybm27.casodeusopatronfachada.home.model.notification.IApiNotification
import com.dybm27.casodeusopatronfachada.home.model.specialist.IApiSpecialist
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class HospitalFacadeTest {

    private lateinit var hospitalFacade: HospitalFacade

    @Mock
    private lateinit var apiAffiliateMock: IApiAffiliate

    @Mock
    private lateinit var apiSpecialistMock: IApiSpecialist

    @Mock
    private lateinit var apiNotificationMock: IApiNotification

    @Mock
    private lateinit var apiAppointmentMock: IApiAppointment

    @Before
    fun init() {
        hospitalFacade = HospitalFacade(
            apiAffiliateMock,
            apiSpecialistMock,
            apiNotificationMock,
            apiAppointmentMock
        )
    }

    @Test
    fun registerSpecialistAppointment_affiliatePatient() {
       /* //Arrange
        val cc = "123456789"
        `when`(apiAffiliateMock.validateAffiliation(cc))
            .thenReturn(false)
        //Act
        val res = hospitalFacade.registerSpecialistAppointment(
            Date(),
            0,
            0,
            cc
        )
        //Assert
        assertEquals(HospitalFacade.Messages.YOU_ARE_NOT_AFFILIATED, res)*/
    }
}