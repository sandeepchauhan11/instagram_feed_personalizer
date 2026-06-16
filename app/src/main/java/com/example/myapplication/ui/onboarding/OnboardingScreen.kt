package com.example.myapplication.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingScreen(
    onOnboardingComplete: () -> Unit
) {
    var currentStep by remember { mutableIntStateOf(1) }

    val steps = listOf(
        OnboardingStep(
            title = "Connect Instagram",
            description = "Connect your Instagram account securely to start the personalization process.",
            buttonText = "Next"
        ),
        OnboardingStep(
            title = "Choose Interests",
            description = "Choose content you want to see more of (Technology, Fitness, Startups, etc.).",
            buttonText = "Next"
        ),
        OnboardingStep(
            title = "Activate Automation",
            description = "Activate background personalization to let the system work for you.",
            buttonText = "Next"
        ),
        OnboardingStep(
            title = "Improve Your Feed",
            description = "Let the application improve your feed over time automatically.",
            buttonText = "Get Started"
        )
    )

    val step = steps[currentStep - 1]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = step.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = step.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {
                if (currentStep < 4) {
                    currentStep++
                } else {
                    onOnboardingComplete()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = step.buttonText)
        }
    }
}

data class OnboardingStep(
    val title: String,
    val description: String,
    val buttonText: String
)
