package com.dybm27.patternfacade.util

import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.TypeSpecialistEntity
import com.dybm27.patternfacade.home.view.data.Specialist
import com.dybm27.patternfacade.home.view.data.TypeSpecialist
import java.text.SimpleDateFormat
import java.util.*

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

fun getFormattedDate(time: Date, s: String): String {
    val format = SimpleDateFormat(s, Locale.getDefault())
    return format.format(time)
}