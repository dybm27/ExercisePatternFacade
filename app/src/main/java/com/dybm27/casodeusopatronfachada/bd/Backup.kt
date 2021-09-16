package com.dybm27.casodeusopatronfachada.bd

import com.dybm27.casodeusopatronfachada.home.model.affiliate.dataaccess.entities.AffiliateEntity
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.TypeSpecialistEntity

object Backup {
    val specialists = listOf(
        SpecialistEntity(1, "Dr. Freddy Niño Prato", 1, "3122293964"),
        SpecialistEntity(2, "Dr. Hugo Oswaldo Alvarado Montoñez", 1, "3025674629"),
        SpecialistEntity(3, "Dr. Javier Alfonso De La Rosa Pareja", 1, "3030309791"),
        SpecialistEntity(4, "Dra. Sandra Patricia Martin Nino", 1, "3221817212"),
        SpecialistEntity(5, "Dr. Federico Bencardino Carpio ", 2, "3041224116"),
        SpecialistEntity(6, "Dr. Luis Alberto Lobo Jacome", 2, "3228788871"),
        SpecialistEntity(7, "Dr. Paulo Alejandro Santos Rivera", 2, "3221032336"),
        SpecialistEntity(8, "Dr. Luis Alfonso Casanova Arambula", 2, "3210351029"),
        SpecialistEntity(9, "Dr. Juan Diego Vargas Jaramillo", 3, "3151749878"),
        SpecialistEntity(10, "Dr. Juan Andres Monsalve Jaimes", 3, "3052255964"),
        SpecialistEntity(11, "Dr. Gabriel Sierra Rosales", 3, "3005617690"),
        SpecialistEntity(12, "Dr. Mario Fernando Quintero Ocaris", 4, "3158116024"),
        SpecialistEntity(13, "Dr. Francisco Hernandez Florez Esteban", 4, "3130337727"),
        SpecialistEntity(14, "Dra. Claudia Margarita Jauregui Rangel", 4, "3126045190"),
        SpecialistEntity(15, "Dr. Javier Omar Mora Vicuña", 5, "3024567062"),
        SpecialistEntity(16, "Dra. Nicol Stefanny Corredor Figueredo", 5, "3213985709"),
        SpecialistEntity(17, "Dr. Samuel Bautista", 5, "3203123256"),
        SpecialistEntity(18, "Dra. Angélica María Duque Leal", 5, "3117784974")
    )
    val types = listOf(
        TypeSpecialistEntity(1, "Endocrinología"),
        TypeSpecialistEntity(2, "Urología"),
        TypeSpecialistEntity(3, "Neurología"),
        TypeSpecialistEntity(4, "Hematología"),
        TypeSpecialistEntity(5, "Ginecología")
    )
    val affiliates = listOf(
        AffiliateEntity("123456789", "Apolonia Fuente Palacio"),
        AffiliateEntity("987654321", "Zoraida Jurado"),
        AffiliateEntity("124578369", "Salvador Escobar"),
        AffiliateEntity("235689147", "Anastasio Vélez Lladó"),
        AffiliateEntity("147852369", "Roxana Iborra Montesinos"),
        AffiliateEntity("258963147", "Diana Noelia Abril Gimenez"),
        AffiliateEntity("369852147", "Heraclio Bermudez"),
    )
}