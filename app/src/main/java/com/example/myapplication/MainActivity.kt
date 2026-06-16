package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.ConnectionScreen
import com.example.myapplication.ui.InterestsScreen
import com.example.myapplication.ui.MainScreen
import com.example.myapplication.ui.SettingsScreen
import com.example.myapplication.ui.onboarding.OnboardingScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

enum class Screen {
    Onboarding,
    Connection,
    Interests,
    Main,
    Settings
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var currentScreen by remember { mutableStateOf(Screen.Onboarding) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    when (currentScreen) {
                        Screen.Onboarding -> OnboardingScreen(
                            onOnboardingComplete = { currentScreen = Screen.Connection }
                        )
                        Screen.Connection -> ConnectionScreen(
                            onConnectionSuccess = { currentScreen = Screen.Interests }
                        )
                        Screen.Interests -> InterestsScreen(
                            onInterestsSaved = { currentScreen = Screen.Main }
                        )
                        Screen.Main -> MainScreen(
                            onSettingsClick = { currentScreen = Screen.Settings }
                        )
                        Screen.Settings -> SettingsScreen(
                            onBack = { currentScreen = Screen.Main }
                        )
                    }
                }
            }
        }
    }
}
