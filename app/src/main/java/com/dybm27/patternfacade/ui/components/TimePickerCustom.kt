package com.dybm27.patternfacade.ui.components

import android.app.TimePickerDialog
import android.content.Context
import android.widget.TimePicker
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.dybm27.patternfacade.util.getFormattedDate
import java.util.*

@Composable
fun TimePickerCustom(
    modifier: Modifier = Modifier,
    context: Context,
    initialDate: Date,
    color: Color = Color.Black,
    isLoading: Boolean = false,
    callback: (hour: Int, min: Int) -> Unit
) {
    val now = Calendar.getInstance()
    now.time = initialDate
    val hourOfDay = now.get(Calendar.HOUR_OF_DAY)
    val minute = now.get(Calendar.MINUTE)
    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, hour: Int, min: Int ->
            now.set(Calendar.HOUR_OF_DAY, hour)
            now.set(Calendar.MINUTE, min)
            callback(hour, min)
        }, hourOfDay, minute, false
    )
    Text(
        text = getFormattedDate(now.time, "h:mm a"),
        modifier = modifier
            .clickable {
                if (!isLoading)
                    timePickerDialog.show()
            },
        color = color,
        fontWeight = FontWeight.Bold
    )
}