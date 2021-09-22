package com.dybm27.patternfacade.home.model

import java.lang.RuntimeException

class ModelException(override val message: String) : RuntimeException() {
    companion object Messages {
        const val YOU_ARE_NOT_AFFILIATED = "No te encuentras afiliado."
        const val SPECIALIST_NOT_AVAILABLE =
            "El especialista no tiene disponibilidad en esa fecha."
        const val THEY_ALREADY_HAVE_A_REGISTERED_APPOINTMENT_WITH_THE_SPECIALIST =
            "Ya tienen cita registrada con el especialista."
        const val REGISTERED_APPOINTMENT =
            "Cita registrada."
        const val INVALID_DATE =
            "Favor revisar la fecha.\n" +
                    "El horario de atención es de lunes a viernes\n"
        const val INVALID_TIME =
            "Favor revisar la hora.\n" +
                    "El horario de atención es de 8am a 12pm y de 2pm a 6pm.\n" +
                    "Y se programa cada 30 min "
    }
}

