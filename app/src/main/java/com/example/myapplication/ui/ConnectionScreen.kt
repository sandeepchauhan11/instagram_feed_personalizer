package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class ConnectionState {
    Disconnected,
    Connecting,
    Connected
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectionScreen(
    onConnectionSuccess: () -> Unit
) {
    var state by remember { mutableStateOf(ConnectionState.Disconnected) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Connect Instagram") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (state) {
                ConnectionState.Disconnected -> {
                    Text("Your Instagram account is not connected.")
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(onClick = { state = ConnectionState.Connecting }) {
                        Text("Connect Now")
                    }
                }
                ConnectionState.Connecting -> {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Connecting to Instagram...")
                    
                    // Simulate connection success after 2 seconds
                    LaunchedEffect(Unit) {
                        kotlinx.coroutines.delay(2000)
                        state = ConnectionState.Connected
                    }
                }
                ConnectionState.Connected -> {
                    Text("Successfully Connected!", color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(onClick = onConnectionSuccess) {
                        Text("Continue")
                    }
                }
            }
        }
    }
}
