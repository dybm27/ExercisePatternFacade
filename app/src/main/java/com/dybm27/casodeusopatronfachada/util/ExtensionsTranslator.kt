package com.dybm27.casodeusopatronfachada.util

import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.casodeusopatronfachada.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import com.dybm27.casodeusopatronfachada.home.view.data.Specialist
import com.dybm27.casodeusopatronfachada.home.view.data.TypeSpecialist

fun TypeSpecialistEntity.fromToView(): TypeSpecialist =
    TypeSpecialist(this.id, this.name)

fun TypeSpecialist.fromToModel(): TypeSpecialistEntity =
    TypeSpecialistEntity(this.id, this.name)

fun List<TypeSpecialistEntity>.fromListTypeSpecialistModelToView(): List<TypeSpecialist> =
    map { it.fromToView() }


fun SpecialistEntity.fromToView(): Specialist =
    Specialist(this.id, this.name, this.idType, this.phoneNumber)

fun Specialist.fromToModel(): SpecialistEntity =
    SpecialistEntity(this.id, this.name, this.idType, this.phoneNumber)

fun List<SpecialistEntity>.fromListSpecialistModelToView(): List<Specialist> =
    map { it.fromToView() }
