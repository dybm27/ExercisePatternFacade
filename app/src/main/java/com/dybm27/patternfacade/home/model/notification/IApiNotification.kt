package com.dybm27.patternfacade.home.model.notification

import java.util.*

interface IApiNotification {
    fun sendNotificationSpecialist(phoneNumber: String, date: Date)
}