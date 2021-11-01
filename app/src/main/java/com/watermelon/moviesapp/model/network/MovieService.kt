package com.watermelon.moviesapp.model.network

import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.model.response.MovieResponse
import com.watermelon.moviesapp.model.response.person.Person
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovieResponse
import com.watermelon.moviesapp.model.response.trending.person.TrendingPersonResponse
import com.watermelon.moviesapp.model.response.trending.tv.TrendingTVResponse
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

    @GET("person/{id}")
    suspend fun getProfile(@Path("id") id: Int) : Response<Person>

    @GET("trending/{mediaType}/{time}")
    fun getTrendingPerson(@Path("media_type") mediaType: String,
                    @Path("time_window") time: String) : Response<TrendingPersonResponse>

    @GET("trending/{mediaType}/{time}")
    fun getTrendingMovie(@Path("media_type") mediaType: String,
                    @Path("time_window") time: String) : Response<TrendingMovieResponse>

    @GET("trending/{mediaType}/{time}")
    fun getTrendingTV(@Path("media_type") mediaType: String,
                         @Path("time_window") time: String) : Response<TrendingTVResponse>
}
