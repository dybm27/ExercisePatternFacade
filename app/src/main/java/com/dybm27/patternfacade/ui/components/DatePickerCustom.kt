package com.dybm27.patternfacade.ui.components

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.dybm27.patternfacade.util.getFormattedDate
import java.util.*

@Composable
fun DatePickerCustom(
    modifier: Modifier = Modifier,
    context: Context,
    initialDate: Date,
    color: Color = Color.Black,
    isLoading: Boolean = false,
    callback: (year: Int, month: Int, dayOfMonth: Int) -> Unit
) {
    val now = Calendar.getInstance()
    now.time = initialDate
    val mYear = now.get(Calendar.YEAR)
    val mMonth = now.get(Calendar.MONTH)
    val mDay = now.get(Calendar.DAY_OF_MONTH)
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            now.set(year, month, dayOfMonth)
            callback(year, month, dayOfMonth)
        }, mYear, mMonth, mDay
    )
    Text(
        text = getFormattedDate(now.time, "MMM d, yyyy"),
        modifier = modifier
            .clickable {
                if (!isLoading)
                    datePickerDialog.show()
            },
        color = color,
        fontWeight = FontWeight.Bold
    )
}