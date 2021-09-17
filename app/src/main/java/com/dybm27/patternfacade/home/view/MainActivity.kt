package com.dybm27.patternfacade.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dybm27.patternfacade.R
import com.dybm27.patternfacade.home.viewmodel.HomeViewModel
import com.dybm27.patternfacade.util.ResultApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val model: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObserver()
    }

    private fun initObserver() {
        model.message.observe(this, {
            when (it.status) {
                ResultApi.Status.LOADING -> {
                    println(it.toString())
                }
                ResultApi.Status.SUCCESS -> {
                    println(it.toString())
                }
            }
        })
        model.specialists.observe(this, {
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
        })
    }
}