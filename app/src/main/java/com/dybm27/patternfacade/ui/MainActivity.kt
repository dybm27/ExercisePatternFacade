package com.dybm27.patternfacade.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.dybm27.patternfacade.R
import com.dybm27.patternfacade.home.view.HomeScreen
import com.dybm27.patternfacade.home.viewmodel.HomeViewModel
import com.dybm27.patternfacade.ui.theme.PatternFacade
import com.dybm27.patternfacade.util.ResultApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatternFacade {
                HomeScreen()
            }
        }
    }
}