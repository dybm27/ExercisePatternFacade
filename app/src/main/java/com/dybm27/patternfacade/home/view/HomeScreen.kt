package com.dybm27.patternfacade.home.view

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dybm27.patternfacade.R
import com.dybm27.patternfacade.home.viewmodel.HomeViewModel
import com.dybm27.patternfacade.ui.components.*

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    context: Context = LocalContext.current
) {
    val resources = LocalContext.current.resources
    val scrollableState = rememberScrollState()
    val dataHome = viewModel.data.value
    val types = viewModel.types.value
    val specialists = viewModel.specialists.value
    val loading = viewModel.isLoading.value
    val openDialog = viewModel.dialog.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollableState)
            .padding(20.dp)
    ) {
        TextTitleCustom(title = stringResource(id = R.string.title))
        DropdownMenuCustom(
            data = types,
            label = stringResource(R.string.label_type),
            input = dataHome.type,
            isLoading = loading,
            selectedItem = viewModel::changeDataType
        )
        DropdownMenuCustom(
            data = specialists,
            label = stringResource(R.string.label_specialist),
            input = dataHome.specialist,
            isLoading = loading,
            selectedItem = viewModel::changeDataSpecialist
        )
        TextFieldCustom(
            label = stringResource(R.string.label_cc),
            text = dataHome.cc,
            keyboardType = KeyboardType.Number,
            isLoading = loading
        ) {
            viewModel.changeDataCc(it, resources.getString(R.string.cc_error))
        }
        TextFieldCustom(
            label = stringResource(R.string.label_name),
            text = dataHome.name,
            isLoading = loading,
            onValueChange = viewModel::changeDataName
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            DatePickerCustom(
                context = context,
                initialDate = dataHome.date,
                color = MaterialTheme.colors.primary,
                isLoading = loading,
                callback = viewModel::changeDataDate
            )
            Spacer(modifier = Modifier.padding(4.dp))
            TimePickerCustom(
                context = context,
                initialDate = dataHome.date,
                color = MaterialTheme.colors.primary,
                isLoading = loading,
                callback = viewModel::changeDataTime
            )
        }
        if (loading) {
            ProgressBarCustom()
        } else {
            ButtonCustom(
                modifier = Modifier.padding(top = 20.dp),
                onClick = viewModel::registerSpecialistAppointment
            )
        }
        if (openDialog.isOpen) {
            AlertDialogCustom(
                title = stringResource(R.string.title_dialog),
                text = openDialog.message,
                openDialog = viewModel::changeDataDialog
            )
        }
    }
}















