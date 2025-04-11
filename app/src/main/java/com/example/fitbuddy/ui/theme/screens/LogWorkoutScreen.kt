// ------------------------------
// 6. ui/screens/LogWorkoutScreen.kt
// ------------------------------
package com.example.fitbuddy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitbuddy.data.model.Workout
import com.example.fitbuddy.viewmodel.WorkoutViewModel

@Composable
fun LogWorkoutScreen(navController: NavController, viewModel: WorkoutViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var name by remember { mutableStateOf("") }
    var reps by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Workout Name") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = reps, onValueChange = { reps = it }, label = { Text("Reps") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = duration, onValueChange = { duration = it }, label = { Text("Duration (min)") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.addWorkout(
                Workout(
                    name = name,
                    reps = reps.toIntOrNull() ?: 0,
                    duration = duration.toIntOrNull() ?: 0
                )
            )
            navController.popBackStack()
        }) {
            Text("Save Workout")
        }
    }
}
