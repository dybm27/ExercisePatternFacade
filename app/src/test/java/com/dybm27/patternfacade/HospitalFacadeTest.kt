package com.dybm27.patternfacade

import com.dybm27.patternfacade.home.model.HospitalFacade
import com.dybm27.patternfacade.home.model.ModelException
import com.dybm27.patternfacade.home.model.affiliate.IAffiliateRepository
import com.dybm27.patternfacade.home.model.appointment.IAppointmentRepository
import com.dybm27.patternfacade.home.model.notification.INotificationRepository
import com.dybm27.patternfacade.home.model.specialist.ISpecialistRepository
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.util.*
import java.util.concurrent.TimeUnit

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

    @Test
    fun test() {
        val days = listOf(0, 1, 2, 3, 4, 5, 6)
        days.forEach {
            if (it !in 1..5) {
                println("yessss $it")
            }
        }
    }


    @Test
    fun test2() {
        val calendar = Calendar.getInstance()
        val dateTest = SimpleDateFormat("MMM d, yyyy h:mm a").parse("Sep 25, 2021 1:30 PM")
        calendar.time = dateTest!!
        val hour = calendar.get(Calendar.HOUR)
        val min = calendar.get(Calendar.MINUTE)
        println(calendar.get(Calendar.DAY_OF_MONTH))
        println(hour)
        println(min)
        println(calendar.get(Calendar.AM_PM))
        if (calendar.get(Calendar.DAY_OF_WEEK) !in 2..6) {
           println("Dia no disponible")
        }
        when (calendar.get(Calendar.AM_PM)) {
            0 -> {
                if (hour !in 8..11 || validateMin(min)) {
                    println("Hora no disponible")
                }
            }
            1 -> {
                if (hour !in 2..5 || validateMin(min)) {
                    println("Hora no disponible")
                }
            }
        }
        val now = Date()
        val diff = dateTest.time - now.time
        println("days --> ${TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)}")
    }

    private fun validateMin(min: Int): Boolean = (min != 0 && min != 30)

    @Test
    fun test3(){
        println(Date().time)
    }
}