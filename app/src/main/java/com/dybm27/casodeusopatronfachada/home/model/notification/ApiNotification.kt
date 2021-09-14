package com.dybm27.casodeusopatronfachada.home.model.notification

import javax.inject.Inject

class ApiNotification @Inject constructor() : IApiNotification {
    override fun sendNotificationSpecialist() {
        println("Notificación enviada")
    }
}