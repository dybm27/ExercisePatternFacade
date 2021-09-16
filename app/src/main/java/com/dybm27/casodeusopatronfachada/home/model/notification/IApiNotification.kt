package com.dybm27.casodeusopatronfachada.home.model.notification

import java.util.*

interface IApiNotification {
    fun sendNotificationSpecialist(phoneNumber: String, date: Date)
}