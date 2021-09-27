package com.dybm27.patternfacade.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.dybm27.patternfacade.home.view.HomeScreen
import com.dybm27.patternfacade.ui.theme.PatternFacade
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