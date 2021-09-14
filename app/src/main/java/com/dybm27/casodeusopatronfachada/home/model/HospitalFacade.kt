package com.dybm27.casodeusopatronfachada.home.model

import com.dybm27.casodeusopatronfachada.home.model.affiliate.IApiAffiliate
import com.dybm27.casodeusopatronfachada.home.model.appointment.dataaccess.IApiAppointment
import com.dybm27.casodeusopatronfachada.home.model.notification.IApiNotification
import com.dybm27.casodeusopatronfachada.home.model.specialist.IApiSpecialist
import java.util.*
import javax.inject.Inject

class HospitalFacade @Inject constructor(
    private val apiAffiliate: IApiAffiliate,
    private val apiSpecialist: IApiSpecialist,
    private val apiNotification: IApiNotification,
    private val apiAppointment: IApiAppointment
) {

    companion object Messages {
        const val YOU_ARE_NOT_AFFILIATED = "No te encuentras afiliado."
        const val SPECIALIST_NOT_AVAILABLE =
            "El especialista no tiene disponibilidad en esa fecha."
        const val THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_WITH_THE_SPECIALIST =
            "Ya tienen cita registrada con el especialista."
        const val REGISTERED_APPOINTMENT =
            "Cita registrada."
    }

    fun registerSpecialistAppointment(
        date: Date,
        idTypeSpecialist: Long,
        idSpecialist: Long,
        cc: String
    ): String {
        if (!apiAffiliate.validateAffiliation(cc)) {
            return YOU_ARE_NOT_AFFILIATED
        }
        if (!apiSpecialist.validateTheAvailabilityOfTheSpecialist(idSpecialist, date)) {
            return SPECIALIST_NOT_AVAILABLE
        }
        if (!apiAppointment.validateExistingAppointment(cc, date, idSpecialist, idTypeSpecialist)) {
            return THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_WITH_THE_SPECIALIST
        }
        apiSpecialist.addAppointment(idSpecialist, date)
        apiNotification.sendNotificationSpecialist()
        return REGISTERED_APPOINTMENT
    }

    fun getDataSpecialist(): Map<String, List<*>> {
        val map = mutableMapOf<String, List<*>>()
        val types = apiSpecialist.getTypeSpecialist()
        val specialist = apiSpecialist.getSpecialist()
        map["types"] = types.fromListTypeSpecialistModelToView()
        map["specialist"] = specialist.fromListSpecialistModelToView()
        return map
    }

}