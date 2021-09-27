package com.dybm27.patternfacade.home.view

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dybm27.patternfacade.R
import com.dybm27.patternfacade.home.view.data.DataScreenHome
import com.dybm27.patternfacade.home.view.data.DataSelects
import com.dybm27.patternfacade.home.view.data.InputWrapper
import com.dybm27.patternfacade.home.view.data.OpenDialog
import com.dybm27.patternfacade.home.viewmodel.HomeViewModel
import com.dybm27.patternfacade.ui.components.*
import com.dybm27.patternfacade.util.ResultApi
import java.util.*

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    context: Context = LocalContext.current
) {
    val resources = LocalContext.current.resources
    val calendar = Calendar.getInstance()
    val scrollableState = rememberScrollState()
    var dataSelect = DataSelects(emptyList(), emptyList())
    var dataHome by rememberSaveable {
        mutableStateOf(DataScreenHome(cc = InputWrapper(minLength = 7, maxLength = 10)))
    }
    var types by rememberSaveable {
        mutableStateOf(listOf<String>())
    }
    var specialists by rememberSaveable {
        mutableStateOf(listOf<String>())
    }
    var cleanSpecialist by rememberSaveable {
        mutableStateOf(false)
    }
    var loading by rememberSaveable {
        mutableStateOf(false)
    }
    val openDialog = rememberSaveable { mutableStateOf(OpenDialog()) }
    val uiStateDataSelects by viewModel.dataSelects.observeAsState(ResultApi.loading())
    when (uiStateDataSelects.status) {
        ResultApi.Status.LOADING -> {
            loading = true
        }
        ResultApi.Status.SUCCESS -> {
            loading = false
            uiStateDataSelects.data?.let { data ->
                dataSelect = data
                types = dataSelect.types.map { it.name }
            }
        }
    }
    val uiStateMessages by viewModel.message.observeAsState()
    uiStateMessages?.let {
        when (it.status) {
            ResultApi.Status.LOADING -> {
                loading = true
            }
            ResultApi.Status.SUCCESS -> {
                loading = false
                it.data?.getContentIfNotHandled()?.let { message ->
                    openDialog.value = OpenDialog(true, message)
                }
            }
        }
    }
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
            input = dataHome.type.name,
            error = dataHome.type.error,
            isLoading = loading
        ) { res ->
            if (res != dataHome.type.name) {
                dataHome = dataHome.copy(type = dataSelect.types.find { it.name == res }!!)
                specialists = dataSelect.specialist.filter { it.idType == dataHome.type.id }
                    .map { it.name }
                cleanSpecialist = true
            }
        }
        DropdownMenuCustom(
            data = specialists,
            label = stringResource(R.string.label_specialist),
            input = dataHome.specialist.name,
            clean = cleanSpecialist,
            error = dataHome.specialist.error,
            isLoading = loading
        ) { res ->
            dataHome = dataHome.copy(specialist = dataSelect.specialist.find { it.name == res }!!)
            cleanSpecialist = false
        }
        TextFieldCustom(
            label = stringResource(R.string.label_cc),
            text = dataHome.cc,
            keyboardType = KeyboardType.Number,
            isLoading = loading
        ) {
            dataHome = dataHome.copy(
                cc = dataHome.cc.copy(
                    value = it,
                    error = it.count() in 1 until dataHome.cc.minLength,
                    messageError = resources.getString(R.string.cc_error)
                )
            )
        }
        TextFieldCustom(
            label = stringResource(R.string.label_name),
            text = dataHome.name,
            isLoading = loading
        ) {
            dataHome = dataHome.copy(name = dataHome.name.copy(value = it, error = false))
        }
        /* if (dataHome.showMessageEmptyError()) {
             Text(
                 text = stringResource(id = R.string.empty_error),
                 color = MaterialTheme.colors.error,
                 style = MaterialTheme.typography.caption,
                 modifier = Modifier.padding(start = 16.dp)
             )
         }*/
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
                isLoading = loading
            ) { year, month, dayOfMonth ->
                calendar.time = dataHome.date
                calendar.set(year, month, dayOfMonth)
                dataHome = dataHome.copy(date = calendar.time)
            }
            Spacer(modifier = Modifier.padding(4.dp))
            TimePickerCustom(
                context = context,
                initialDate = dataHome.date,
                color = MaterialTheme.colors.primary,
                isLoading = loading
            ) { hour, min ->
                calendar.time = dataHome.date
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, min)
                dataHome = dataHome.copy(date = calendar.time)
            }
        }
        if (loading) {
            ProgressBarCustom()
        } else {
            ButtonCustom(modifier = Modifier.padding(top = 20.dp)) {
                dataHome = dataHome.copy(
                    type = dataHome.type.copy(error = dataHome.type.isEmpty()),
                    specialist = dataHome.specialist.copy(error = dataHome.specialist.isEmpty()),
                    cc = dataHome.cc.copy(error = dataHome.cc.isEmpty()),
                    name = dataHome.name.copy(error = dataHome.name.isEmpty())
                )
                if (!dataHome.showMessageEmptyError())
                    viewModel.registerSpecialistAppointment(dataHome)

            }
        }
        if (openDialog.value.isOpen) {
            AlertDialogCustom(
                title = stringResource(R.string.title_dialog),
                text = openDialog.value.message
            ) { res ->
                openDialog.value = OpenDialog(res)
            }
        }
    }
}















