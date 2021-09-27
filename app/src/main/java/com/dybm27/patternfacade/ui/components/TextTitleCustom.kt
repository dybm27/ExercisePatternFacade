package com.dybm27.patternfacade.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TextTitleCustom(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.h2,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 20.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}