// ------------------------------
// 4. viewmodel/WorkoutViewModel.kt
// ------------------------------
package com.example.fitbuddy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitbuddy.data.model.Workout
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.flow.update

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val db: FirebaseFirestore
) : ViewModel() {
    private val _workouts = MutableStateFlow<List<Workout>>(emptyList())
    val workouts: StateFlow<List<Workout>> = _workouts

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun addWorkout(workout: Workout) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                db.collection("workouts")
                    .add(workout)
                    .await()
                fetchWorkouts() // Refresh the list after adding
            } catch (e: Exception) {
                _error.value = "Failed to add workout: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchWorkouts() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                val result = db.collection("workouts")
                    .get()
                    .await()
                val workoutList = result.mapNotNull { it.toObject(Workout::class.java) }
                _workouts.update { workoutList }
            } catch (e: Exception) {
                _error.value = "Failed to fetch workouts: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}