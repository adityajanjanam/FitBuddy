package com.example.fitbuddy.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                Text(text = "Duration: ${workout.duration}")
            }
        }
    }
}

// Move this to a repository or ViewModel later
fun fetchWorkouts(): List<Workout> {
    return listOf(
        Workout("Push Ups", 15, "10 mins"),
        Workout("Planks", 3, "5 mins"),
        Workout("Squats", 20, "15 mins")
    )
}
