package com.dybm27.patternfacade.home.view.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputWrapper(
    var value: String = "",
    var error: Boolean = false,
    val minLength: Int = 0,
    val maxLength: Int = 0,
    val messageError: String = ""
) : Parcelable {
    fun isEmpty(): Boolean = value.isEmpty() || error
}