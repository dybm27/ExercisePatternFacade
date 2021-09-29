package com.dybm27.patternfacade.home.view.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class DataScreenHome(
    var type: InputWrapper = InputWrapper(),
    var specialist: InputWrapper = InputWrapper(),
    var cc: InputWrapper = InputWrapper(),
    var name: InputWrapper = InputWrapper(),
    var date: Date = Date()
) : Parcelable {
    fun showMessageEmptyError(): Boolean =
        type.isEmpty() || specialist.isEmpty() || cc.isEmpty() || name.isEmpty()
}
