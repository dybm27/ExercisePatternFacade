package com.dybm27.patternfacade.home.view.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class OpenDialog(
    var isOpen: Boolean = false,
    var message: String = ""
) : Parcelable