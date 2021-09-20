package com.dybm27.patternfacade.home.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dybm27.patternfacade.home.view.data.TypeSpecialist
import com.dybm27.patternfacade.home.viewmodel.HomeViewModel
import com.dybm27.patternfacade.util.ResultApi

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val uiStateTypes = viewModel.dataSelects.observeAsState()
    uiStateTypes.value?.let {
        when (it.status) {
            ResultApi.Status.LOADING -> {
                println("LOADING")
                println("Open progress")
                println(it.toString())
            }
            ResultApi.Status.SUCCESS -> {
                println("SUCCESS")
                println("Close progress")
                println(it.toString())
            }
        }
    }
    val uiStateMessage = viewModel.message.observeAsState()
    uiStateMessage.value?.let {
        when (it.status) {
            ResultApi.Status.LOADING -> {
                println("LOADING")
                println("Open progress")
                println(it.toString())
            }
            ResultApi.Status.SUCCESS -> {
                println("SUCCESS")
                println("Close progress")
                println(it.toString())
            }
        }
    }
    DropdownMenuCustom()
}

@Composable
fun DropdownMenuCustom() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
    }

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Item1", "Item2", "Item3")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.ArrowDropUp //it requires androidx.compose.material:material-icons-extended
    else
        Icons.Filled.ArrowDropDown

    Column() {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("Label") },
            enabled = false,
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                }) {
                    Text(text = label)
                }
            }
        }
    }
}