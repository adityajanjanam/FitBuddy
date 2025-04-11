package com.example.fitbuddy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitbuddy.data.remote.RetrofitClient
import kotlinx.coroutines.launch

@Composable
fun QuoteScreen(navController: NavController) {
    var quote by remember { mutableStateOf("Loading...") }
    var author by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(true) {
        scope.launch {
            try {
                val response = RetrofitClient.api.getRandomQuote()
                val firstQuote = response.firstOrNull()
                if (firstQuote != null) {
                    quote = firstQuote.q
                    author = firstQuote.a
                } else {
                    quote = "No quote found."
                }
            } catch (e: Exception) {
                quote = "Failed to fetch quote."
                author = e.message ?: ""
            }
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "\"$quote\"", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "- $author", style = MaterialTheme.typography.labelMedium)
    }
}
