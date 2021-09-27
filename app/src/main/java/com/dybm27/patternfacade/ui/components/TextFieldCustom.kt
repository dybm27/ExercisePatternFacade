package com.dybm27.patternfacade.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.dybm27.patternfacade.home.view.data.InputWrapper

@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    label: String,
    text: InputWrapper,
    keyboardType: KeyboardType = KeyboardType.Text,
    isLoading: Boolean = false,
    onValueChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                if (text.maxLength == 0 || it.length <= text.maxLength)
                    onValueChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = text.error,
            label = { Text(if (text.error) "$label*" else label) },
            enabled = !isLoading
        )
        if (text.error && text.value.count() > 0) {
            Text(
                text = text.messageError,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}