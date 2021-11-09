package com.watermelon.moviesapp.model.network

import com.watermelon.moviesapp.model.response.credits.Cast
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
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("list/1")
    suspend fun getMovies(@Query("api_key") apiKey: String) : Response<MoviesResponse>

    @GET("search/movie")
    suspend fun searchForMovie(
        @Query("api_key") apiKey: String,
        @Query("query") movieTitle:String,
    ) : Response<MovieResponse>

    @GET("person/{id}")
    suspend fun getProfile(@Path("id") id: Int,
                   @Query("api_key") apiKey: String,
    ) : Response<Person>

    @GET("trending/{mediaType}/{time}")
    suspend fun getTrendingPerson(@Path("media_type") mediaType: String,
                    @Path("time_window") time: String) : Response<TrendingPersonResponse>

    @GET("trending/{mediaType}/{time}")
    suspend fun getTrendingMovie(@Path("media_type") mediaType: String,
                    @Path("time_window") time: String) : Response<TrendingMovieResponse>

    @GET("trending/{mediaType}/{time}")
    suspend fun getTrendingTV(@Path("media_type") mediaType: String,
                         @Path("time_window") time: String) : Response<TrendingTVResponse>

    @GET("trending/{mediaType}/{time}")
    suspend fun getTrendingAll(@Path("media_type") mediaType: String,
                      @Path("time_window") time: String) : Response<TrendingAllResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey: String,
    ) : Response<Movie>
    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCast(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey: String,
    ) : Response<Credits>
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String,
    ) : Response<Genres>

    @GET("tv/latest")
    suspend fun getLatestTvShow(
        @Query("api_key") apiKey: String,
    ) : Response<MovieResponse>

}
