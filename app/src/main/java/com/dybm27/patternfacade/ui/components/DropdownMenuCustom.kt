package com.dybm27.patternfacade.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import com.dybm27.patternfacade.home.view.data.InputWrapper

@Composable
fun DropdownMenuCustom(
    modifier: Modifier = Modifier,
    data: List<String>,
    label: String,
    input: InputWrapper,
    isLoading: Boolean = false,
    selectedItem: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val source = remember {
        MutableInteractionSource()
    }
    if (source.collectIsPressedAsState().value) expanded = true
    Column(modifier = modifier) {
        OutlinedTextField(
            value = input.value,
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            interactionSource = source,
            label = { Text(if (input.error) "$label*" else label) },
            isError = input.error,
            readOnly = true,
            enabled = !isLoading,
            trailingIcon = {
                Icon(
                    if (expanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                    "contentDescription"
                )
            }, maxLines = 1
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            data.forEach { label ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedItem(label)
                }) {
                    Text(text = label)
                }
            }
        }
    }
}


/*
@Composable
fun DropdownMenuCustom2(
    modifier: Modifier = Modifier,
    data: List<String>,
    label: String,
    input: String,
    clean: Boolean = false,
    selectedItem: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    Column(modifier = modifier) {
        OutlinedTextField(
            value = if (!clean) input else "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
                .clickable {
                    expanded = !expanded
                },
            label = { Text(label) },
            enabled = false,
            trailingIcon = {
                Icon(
                    if (expanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                    "contentDescription"
                )
            }, maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = if (expanded)  MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high) else LocalContentColor.current.copy(
                    LocalContentAlpha.current
                ),
                disabledLabelColor = if (expanded) MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high) else MaterialTheme.colors.onSurface.copy(
                    ContentAlpha.medium
                ),
                disabledBorderColor=  if (expanded) MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high) else MaterialTheme.colors.onSurface.copy(
                    ContentAlpha.medium
                ),
                disabledTrailingIconColor = MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.IconOpacity)
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            data.forEach { label ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedItem(label)
                }) {
                    Text(text = label)
                }
            }
        }
    }
}*/