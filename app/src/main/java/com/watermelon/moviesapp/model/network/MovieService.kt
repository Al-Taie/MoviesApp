package com.watermelon.moviesapp.model.network

import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.model.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("list/1")
    suspend fun getMovies() : Response<MovieResponse>

    @GET("search/movie")
    suspend fun searchForMovie(
        @Query("api_key") apiKey: String,
        @Query("query") movieTitle:String,
    ) : Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Query("api_key") apiKey: String,
        @Path("movie_id") movieId:Int,
    ) : Response<MovieResponse>
}
