package com.example.fitbuddy.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.fitbuddy.data.model.Workout

@Composable
fun HistoryScreen() {
    val workouts = fetchWorkouts()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        workouts.forEach { workout ->
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(text = "Workout: ${workout.name}")
                Text(text = "Reps: ${workout.reps}")
                Text(text = "Duration: ${workout.duration} min")
            }
        }
    }
}

// Replace with ViewModel later
fun fetchWorkouts(): List<Workout> {
    return listOf(
        Workout("Push Ups", 15, 10),
        Workout("Planks", 3, 5),
        Workout("Squats", 20, 15)
    )
}
