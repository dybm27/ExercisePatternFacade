package com.dybm27.patternfacade.home.view.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TypeSpecialist(
    val id: Long = 0,
    val name: String = "",
    var error: Boolean = false,
    var messageError: String = ""
) : Parcelable {
    fun isEmpty(): Boolean = id == 0L
}
