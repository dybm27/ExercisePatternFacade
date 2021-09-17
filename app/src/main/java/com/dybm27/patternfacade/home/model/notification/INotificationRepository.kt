package com.dybm27.patternfacade.home.model.notification

import java.util.*

interface INotificationRepository {
    fun sendNotificationSpecialist(phoneNumber: String, date: Date)
}