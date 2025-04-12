// ------------------------------
// 5. ui/screens/HomeScreen.kt
// ------------------------------
package com.example.fitbuddy.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to FitBuddy", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("logWorkout") }) {
            Text("Log Workout")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("quote") }) {
            Text("Motivational Quote")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("history") }) {
            Text("View History")
        }
    }
}
