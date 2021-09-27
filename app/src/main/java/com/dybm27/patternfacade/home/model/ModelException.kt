package com.dybm27.patternfacade.home.model

import java.lang.RuntimeException

class ModelException(override val message: String) : RuntimeException() {
    companion object Messages {
        const val YOU_ARE_NOT_AFFILIATED = "No extiste un paciente afiliado con ese documento."
        const val SPECIALIST_NOT_AVAILABLE =
            "El especialista no tiene disponibilidad en esa fecha."
        const val THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_FOR_THIS_DATE =
            "El paciente ya tiene una cita agendada para esa fecha."
        const val THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_WITH_THE_SPECIALIST =
            "El paciente ya tiene una cita agendada con el especialista."
        const val REGISTERED_APPOINTMENT =
            "Cita agendada."
        const val INVALID_DATE =
            "El horario de atención es de lunes a viernes."
        const val INVALID_TIME =
            "El horario de atención es de 8am a 12pm y de 2pm a 6pm."
        const val INVALID_TIME2 =
            "La cita se debe agendar cada 30 minutos."
        const val INVALID_ANTICIPATION_DAYS =
            "La cita se debe agendar por lo menos con 3 días de anticipación."
    }
}

