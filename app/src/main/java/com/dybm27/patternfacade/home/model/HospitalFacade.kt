package com.dybm27.patternfacade.home.model

import com.dybm27.patternfacade.home.model.affiliate.IAffiliateRepository
import com.dybm27.patternfacade.home.model.appointment.IAppointmentRepository
import com.dybm27.patternfacade.home.model.notification.INotificationRepository
import com.dybm27.patternfacade.home.model.specialist.ISpecialistRepository
import com.dybm27.patternfacade.home.view.data.Specialist
import com.dybm27.patternfacade.home.view.data.TypeSpecialist
import com.dybm27.patternfacade.util.ResultApi
import com.dybm27.patternfacade.util.fromListSpecialistModelToView
import com.dybm27.patternfacade.util.fromListTypeSpecialistModelToView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*
import javax.inject.Inject

class HospitalFacade @Inject constructor(
    private val affiliateRepository: IAffiliateRepository,
    private val specialistRepository: ISpecialistRepository,
    private val notificationRepository: INotificationRepository,
    private val appointmentRepository: IAppointmentRepository
) : IHospitalFacade {

    companion object Messages {
        const val YOU_ARE_NOT_AFFILIATED = "No te encuentras afiliado."
        const val SPECIALIST_NOT_AVAILABLE =
            "El especialista no tiene disponibilidad en esa fecha."
        const val THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_WITH_THE_SPECIALIST =
            "Ya tienen cita registrada con el especialista."
        const val REGISTERED_APPOINTMENT =
            "Cita registrada."
    }


    override suspend fun registerSpecialistAppointment(
        date: Date,
        typeSpecialist: TypeSpecialist,
        specialist: Specialist,
        cc: String
    ): Flow<ResultApi<String>> =
        flow {
            emit(ResultApi.loading())
            if (!affiliateRepository.validateAffiliation(cc)) {
                emit(ResultApi.success(YOU_ARE_NOT_AFFILIATED))
            } else if (!specialistRepository.validateTheAvailabilityOfTheSpecialist(
                    specialist.id,
                    date
                )
            ) {
                emit(ResultApi.success(SPECIALIST_NOT_AVAILABLE))
            } else if (!appointmentRepository.validateExistingAppointment(
                    cc,
                    date,
                    specialist.id,
                    typeSpecialist.id
                )
            ) {
                emit(
                    ResultApi.success(
                        THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_WITH_THE_SPECIALIST
                    )
                )
            } else {
                specialistRepository.addAppointment(specialist.id, date)
                notificationRepository.sendNotificationSpecialist(specialist.phoneNumber, date)
                emit(ResultApi.success(REGISTERED_APPOINTMENT))
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun getTypeSpecialists(): Flow<ResultApi<List<TypeSpecialist>>> =
        flow {
            emit(ResultApi.loading())
            emit(
                ResultApi.success(
                    specialistRepository.getTypeSpecialist().fromListTypeSpecialistModelToView()
                )
            )
        }.flowOn(Dispatchers.IO)

    override suspend fun getSpecialists(): Flow<ResultApi<List<Specialist>>> =
        flow {
            emit(ResultApi.loading())
            emit(ResultApi.success(specialistRepository.getSpecialist().fromListSpecialistModelToView()))
        }.flowOn(Dispatchers.IO)

}

