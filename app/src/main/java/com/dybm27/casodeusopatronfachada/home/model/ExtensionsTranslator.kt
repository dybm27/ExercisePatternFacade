package com.dybm27.casodeusopatronfachada.home.model

import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import com.dybm27.casodeusopatronfachada.home.view.data.Specialist
import com.dybm27.casodeusopatronfachada.home.view.data.TypeSpecialist

private fun fromTypeSpecialistModelToView(typeSpecialist: TypeSpecialistEntity): TypeSpecialist =
    TypeSpecialist(typeSpecialist.id, typeSpecialist.name)

fun List<TypeSpecialistEntity>.fromListTypeSpecialistModelToView(): List<TypeSpecialist> =
    map { fromTypeSpecialistModelToView(it) }


private fun fromSpecialistModelToView(specialist: SpecialistEntity): Specialist =
    Specialist(specialist.id, specialist.name, specialist.idType, specialist.phoneNumber)

fun List<SpecialistEntity>.fromListSpecialistModelToView(): List<Specialist> =
    map { fromSpecialistModelToView(it) }
