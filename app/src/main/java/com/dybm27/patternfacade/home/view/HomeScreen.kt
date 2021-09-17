package com.dybm27.patternfacade.home.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dybm27.patternfacade.home.viewmodel.HomeViewModel
import com.dybm27.patternfacade.util.ResultApi

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val uiState = viewModel.types.observeAsState()
    uiState.value?.let {
        when (it.status) {
            ResultApi.Status.LOADING -> {
                println(uiState.toString())
            }
            ResultApi.Status.SUCCESS -> {
                println(uiState.toString())
            }
        }
    }
    /*   model.specialists.observe(this, {
           when (it.status) {
               ResultApi.Status.LOADING -> {
                   println(it.toString())
               }
               ResultApi.Status.SUCCESS -> {
                   println(it.toString())
               }
           }
       })
       model.types.observe(this, {
           when (it.status) {
               ResultApi.Status.LOADING -> {
                   println(it.toString())
               }
               ResultApi.Status.SUCCESS -> {
                   println(it.toString())
               }
           }
       })*/

    Text(text = "Hello world")
}