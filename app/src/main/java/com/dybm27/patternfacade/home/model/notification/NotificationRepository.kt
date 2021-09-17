package com.dybm27.patternfacade.home.model.notification

import java.util.*
import javax.inject.Inject

class NotificationRepository @Inject constructor() : INotificationRepository {
    override fun sendNotificationSpecialist(phoneNumber: String, date: Date) {
        println("Notificación enviada al numero $phoneNumber")
        println("Se agendo cita para la fecha ${date.time}")
    }
}