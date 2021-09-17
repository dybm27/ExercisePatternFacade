package com.dybm27.patternfacade.home.model.notification

import java.util.*
import javax.inject.Inject

class ApiNotification @Inject constructor() : IApiNotification {
    override fun sendNotificationSpecialist(phoneNumber: String, date: Date) {
        println("Notificación enviada al numero $phoneNumber")
        println("Se agendo cita para la fecha ${date.time}")
    }
}