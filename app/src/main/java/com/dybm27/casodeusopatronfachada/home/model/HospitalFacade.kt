package com.dybm27.casodeusopatronfachada.home.model

import com.dybm27.casodeusopatronfachada.home.model.affiliate.IApiAffiliate
import com.dybm27.casodeusopatronfachada.home.model.appointment.dataaccess.IApiAppointment
import com.dybm27.casodeusopatronfachada.home.model.notification.IApiNotification
import com.dybm27.casodeusopatronfachada.home.model.specialist.IApiSpecialist
import com.dybm27.casodeusopatronfachada.home.view.data.Specialist
import com.dybm27.casodeusopatronfachada.home.view.data.TypeSpecialist
import com.dybm27.casodeusopatronfachada.util.ResultApi
import com.dybm27.casodeusopatronfachada.util.fromListSpecialistModelToView
import com.dybm27.casodeusopatronfachada.util.fromListTypeSpecialistModelToView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*
import javax.inject.Inject

class HospitalFacade @Inject constructor(
    private val apiAffiliate: IApiAffiliate,
    private val apiSpecialist: IApiSpecialist,
    private val apiNotification: IApiNotification,
    private val apiAppointment: IApiAppointment
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
            if (!apiAffiliate.validateAffiliation(cc)) {
                emit(ResultApi.success(YOU_ARE_NOT_AFFILIATED))
            } else if (!apiSpecialist.validateTheAvailabilityOfTheSpecialist(
                    specialist.id,
                    date
                )
            ) {
                emit(ResultApi.success(SPECIALIST_NOT_AVAILABLE))
            } else if (!apiAppointment.validateExistingAppointment(
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
                apiSpecialist.addAppointment(specialist.id, date)
                apiNotification.sendNotificationSpecialist(specialist.phoneNumber, date)
                emit(ResultApi.success(REGISTERED_APPOINTMENT))
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun getTypeSpecialists(): Flow<ResultApi<List<TypeSpecialist>>> =
        flow {
            emit(ResultApi.loading())
            emit(
                ResultApi.success(
                    apiSpecialist.getTypeSpecialist().fromListTypeSpecialistModelToView()
                )
            )
        }.flowOn(Dispatchers.IO)

    override suspend fun getSpecialists(): Flow<ResultApi<List<Specialist>>> =
        flow {
            emit(ResultApi.loading())
            emit(ResultApi.success(apiSpecialist.getSpecialist().fromListSpecialistModelToView()))
        }.flowOn(Dispatchers.IO)

}

