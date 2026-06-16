package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestsScreen(
    onInterestsSaved: (List<String>) -> Unit
) {
    val interests = listOf(
        "Technology", "Artificial Intelligence", "Startups", "Business",
        "Finance", "Fitness", "Health", "Education", "Travel", "Gaming"
    )
    val selectedInterests = remember { mutableStateListOf<String>() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Choose Interests") })
        },
        bottomBar = {
            Button(
                onClick = { onInterestsSaved(selectedInterests.toList()) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                enabled = selectedInterests.isNotEmpty()
            ) {
                Text("Save & Continue")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(interests) { interest ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = interest, modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = selectedInterests.contains(interest),
                        onCheckedChange = { checked ->
                            if (checked) {
                                selectedInterests.add(interest)
                            } else {
                                selectedInterests.remove(interest)
                            }
                        }
                    )
                }
            }
        }
    }
}
