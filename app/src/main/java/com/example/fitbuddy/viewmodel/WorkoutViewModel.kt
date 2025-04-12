// ------------------------------
// 4. viewmodel/WorkoutViewModel.kt
// ------------------------------
package com.example.fitbuddy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitbuddy.data.model.Workout
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _workouts = MutableStateFlow<List<Workout>>(emptyList())
    val workouts: StateFlow<List<Workout>> = _workouts

    fun addWorkout(workout: Workout) {
        db.collection("workouts")
            .add(workout)
    }

    fun fetchWorkouts() {
        db.collection("workouts")
            .get()
            .addOnSuccessListener { result ->
                val workoutList = result.mapNotNull { it.toObject(Workout::class.java) }
                _workouts.value = workoutList
            }
    }
}