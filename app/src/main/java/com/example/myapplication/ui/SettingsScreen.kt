package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                ListItem(
                    headlineContent = { Text("Profile Information") },
                    supportingContent = { Text("Manage your account details") },
                    modifier = Modifier.padding(8.dp)
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Instagram Connection") },
                    supportingContent = { Text("Connected as @user") },
                    modifier = Modifier.padding(8.dp)
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Content Preferences") },
                    supportingContent = { Text("Technology, Fitness, Startups") },
                    modifier = Modifier.padding(8.dp)
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Automation Controls") },
                    supportingContent = { Text("Pause or stop background activity") },
                    modifier = Modifier.padding(8.dp),
                    trailingContent = {
                        Switch(checked = true, onCheckedChange = {})
                    }
                )
            }
            item {
                Divider()
            }
            item {
                TextButton(
                    onClick = { /* TODO: Logout */ },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Logout")
                }
            }
        }
    }
}
