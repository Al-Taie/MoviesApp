package com.watermelon.moviesapp.model.network

import com.watermelon.moviesapp.model.response.credits.Credits
import com.watermelon.moviesapp.model.response.genres.Genres
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.model.response.movies.MoviesResponse
import com.watermelon.moviesapp.model.response.person.Person
import com.watermelon.moviesapp.model.response.trending.all.TrendingAllResponse
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovieResponse
import com.watermelon.moviesapp.model.response.trending.person.TrendingPersonResponse
import com.watermelon.moviesapp.model.response.trending.tv.TrendingTVResponse
import com.watermelon.moviesapp.utils.Constant
import com.watermelon.moviesapp.utils.MediaType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("list/1")
    suspend fun getMovies(@Query("api_key") apiKey: String = Constant.API_KEY) : Response<MoviesResponse>

    @GET("search/movie")
    suspend fun searchForMovie(
        @Query("query") movieTitle:String,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<MovieResponse>

    @GET("person/{id}")
    suspend fun getProfile(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<Person>

    @GET("trending/${MediaType.PERSON}/{time_window}")
    suspend fun getTrendingPerson(
        @Path("time_window") time: String,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<TrendingPersonResponse>

    @GET("trending/${MediaType.MOVIE}/{time_window}")
    suspend fun getTrendingMovie(
        @Path("time_window") time: String,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<TrendingMovieResponse>

    @GET("trending/${MediaType.TV}/{time_window}")
    suspend fun getTrendingTV(
        @Path("time_window") time: String,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<TrendingTVResponse>

    @GET("trending/${MediaType.ALL}/{time_window}")
    suspend fun getTrendingAll(
        @Path("time_window") time: String,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<TrendingAllResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<Movie>

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCast(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<Credits>

    @GET("genre/movie/list")
    suspend fun getGenres(@Query("api_key") apiKey: String = Constant.API_KEY) : Response<Genres>

    @GET("discover/movie")
    suspend fun getMoviesOfOneGenre(
        @Query("with_genres") id: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY) : Response<MovieResponse>


}
