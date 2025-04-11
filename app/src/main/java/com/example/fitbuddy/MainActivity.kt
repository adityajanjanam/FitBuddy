package com.example.fitbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.fitbuddy.ui.screens.* // update if needed
import com.example.fitbuddy.ui.theme.FitBuddyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitBuddyTheme {
                FitBuddyApp()
            }
        }
    }
}

@Composable
fun FitBuddyApp() {
    val navController = rememberNavController()
    FitBuddyNavHost(navController = navController)
}

@Composable
fun FitBuddyNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("logWorkout") {
            LogWorkoutScreen(navController)
        }
        composable("quote") {
            QuoteScreen(navController)
        }
        composable("history") {
            HistoryScreen(navController)
        }
    }
}
