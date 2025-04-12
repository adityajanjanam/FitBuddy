// ------------------------------
// 3. data/remote/RetrofitClient.kt
// ------------------------------
package com.example.fitbuddy.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://zenquotes.io/api/"

    val api: QuoteApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuoteApiService::class.java)
}
