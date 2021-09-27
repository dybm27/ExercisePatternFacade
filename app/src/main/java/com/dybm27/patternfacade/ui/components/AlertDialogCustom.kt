package com.dybm27.patternfacade.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogCustom(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    openDialog: (Boolean) -> Unit
) {
    AlertDialog(modifier = modifier, onDismissRequest = {},
        title = {
            Text(
                title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3
            )
        },
        text = { Text(text, style = MaterialTheme.typography.h4) },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = { openDialog(false) }
                ) {
                    Text("ACEPTAR", style = MaterialTheme.typography.body1)
                }
            }
        })
} 