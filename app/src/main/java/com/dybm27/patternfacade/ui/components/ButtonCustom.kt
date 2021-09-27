package com.dybm27.patternfacade.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCustom(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier = modifier.fillMaxWidth()) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .align(Alignment.Center),
            onClick = { onClick() }) {
            Text(
                text = "Agendar",
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}