package com.dybm27.patternfacade

import com.dybm27.patternfacade.home.model.HospitalFacade
import com.dybm27.patternfacade.home.model.affiliate.IAffiliateRepository
import com.dybm27.patternfacade.home.model.appointment.IAppointmentRepository
import com.dybm27.patternfacade.home.model.notification.INotificationRepository
import com.dybm27.patternfacade.home.model.specialist.ISpecialistRepository
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HospitalFacadeTest {

    private lateinit var hospitalFacade: HospitalFacade

    @Mock
    private lateinit var affiliateRepositoryMock: IAffiliateRepository

    @Mock
    private lateinit var apiSpecialistMock: ISpecialistRepository

    @Mock
    private lateinit var apiNotificationMock: INotificationRepository

    @Mock
    private lateinit var appointmentRepositoryMock: IAppointmentRepository

    @Before
    fun init() {
        hospitalFacade = HospitalFacade(
            affiliateRepositoryMock,
            apiSpecialistMock,
            apiNotificationMock,
            appointmentRepositoryMock
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