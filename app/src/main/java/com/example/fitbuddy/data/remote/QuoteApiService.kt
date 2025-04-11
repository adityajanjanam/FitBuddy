package com.example.fitbuddy.data.remote

import retrofit2.http.GET

interface QuoteApiService {
    @GET("random")
    suspend fun getRandomQuote(): List<Quote>
}
