package com.watermelon.moviesapp.model.network

import com.watermelon.moviesapp.model.response.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("list/1")
    fun getMovies() : Response<Movie>

    @GET("search/movie")
   suspend fun searchForMovie(
        @Query("query") movieTitle:String,
    ) : Response<Movie>
}
