package com.watermelon.moviesapp.model.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private const val baseUrl = "https://api.themoviedb.org/4/"
    private val client = OkHttpClient.Builder().addInterceptor(MovieInterceptor()).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    val apiService = retrofit.create(MovieService::class.java)
}
