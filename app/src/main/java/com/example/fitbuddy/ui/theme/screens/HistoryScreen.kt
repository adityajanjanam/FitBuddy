package com.example.fitbuddy.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fitbuddy.data.model.Workout
import com.example.fitbuddy.viewmodel.WorkoutViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HistoryScreen() {
    val viewModel: WorkoutViewModel = viewModel()
    val workouts by viewModel.workouts.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWorkouts()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (error != null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = error!!,
                    color = MaterialTheme.colorScheme.error
                )
            }
        } else if (workouts.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No workouts logged yet")
            }
        } else {
            workouts.forEach { workout ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = workout.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Reps: ${workout.reps}")
                        Text(text = "Duration: ${workout.duration} min")
                    }
                }
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
