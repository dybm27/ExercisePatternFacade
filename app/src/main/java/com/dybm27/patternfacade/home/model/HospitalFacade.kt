package com.dybm27.patternfacade.home.model

import com.dybm27.patternfacade.home.model.affiliate.IAffiliateRepository
import com.dybm27.patternfacade.home.model.appointment.IAppointmentRepository
import com.dybm27.patternfacade.home.model.notification.INotificationRepository
import com.dybm27.patternfacade.home.model.specialist.ISpecialistRepository
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import com.dybm27.patternfacade.home.view.data.DataSelects
import com.dybm27.patternfacade.util.ResultApi
import com.dybm27.patternfacade.util.fromListSpecialistModelToView
import com.dybm27.patternfacade.util.fromListTypeSpecialistModelToView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject

class HospitalFacade @Inject constructor(
    private val affiliateRepository: IAffiliateRepository,
    private val specialistRepository: ISpecialistRepository,
    private val notificationRepository: INotificationRepository,
    private val appointmentRepository: IAppointmentRepository
) : IHospitalFacade {

    override suspend fun registerSpecialistAppointment(
        date: Date,
        typeSpecialist: TypeSpecialistEntity,
        specialist: SpecialistEntity,
        cc: String
    ): Flow<ResultApi<String>> =
        flow {
            emit(ResultApi.loading())
            delay(2000)
            try {
                appointmentRepository.validateDate(date)
                affiliateRepository.validateAffiliation(cc)
                specialistRepository.validateTheAvailabilityOfTheSpecialist(
                    specialist.id,
                    date
                )
                appointmentRepository.validateExistingAppointment(
                    cc,
                    date,
                    specialist.id,
                    typeSpecialist.id
                )
                specialistRepository.addAppointment(specialist.id, date)
                emit(
                    ResultApi.success(
                        appointmentRepository.registerAppointment(
                            cc,
                            date,
                            specialist.id,
                            typeSpecialist.id
                        )
                    )
                )
                notificationRepository.sendNotificationSpecialist(
                    specialist.phoneNumber,
                    date
                )
            } catch (e: ModelException) {
                emit(ResultApi.success(e.message))
            }
        }.flowOn(Dispatchers.IO)

    override fun getDataSelects(): Flow<ResultApi<DataSelects>> =
        flow {
            emit(ResultApi.loading())
            delay(2000)
            specialistRepository.getTypeSpecialist()
                .combine(specialistRepository.getSpecialist()) { types, specialist ->
                    DataSelects(
                        types.fromListTypeSpecialistModelToView(),
                        specialist.fromListSpecialistModelToView()
                    )
                }.collect {
                    emit(ResultApi.success(it))
                }
        }.flowOn(Dispatchers.IO)
}

