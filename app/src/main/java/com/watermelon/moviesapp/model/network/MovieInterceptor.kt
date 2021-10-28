package com.watermelon.moviesapp.model.network

import okhttp3.Interceptor
import okhttp3.Response

class MovieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZDBiMTExNzBhN2MwYzdhYmI1YWY4OWZjYWYzNDYyNiIsInN1YiI6IjYxNzQ1NzIwNTI5NGU3MDA0NGYxNDFmMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.chN72zXaI7ac9CuAr3UsmkMpqvepHXe-m-NLlu-R-Ps")
            .addHeader("Content-Type", "application/json;charset=utf-8")
            .build()
        return chain.proceed(request)
    }
}
