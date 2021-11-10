package com.watermelon.moviesapp.model.repository


import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.network.API
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object MovieRepository {
    fun getMovies() = wrapWithFlow { API.apiService.getMovies() }

    fun getMovieDetails(movieId: Int) = wrapWithFlow { API.apiService.getMovieDetails(movieId) }

    fun getMovieCast(movieId: Int) = wrapWithFlow { API.apiService.getMovieCast(movieId) }

    fun getProfile(id: Int) = wrapWithFlow { API.apiService.getProfile(id) }

    fun getTrendingPerson(time: String) = wrapWithFlow { API.apiService.getTrendingPerson(time) }

    fun getTrendingMovie(time: String) = wrapWithFlow { API.apiService.getTrendingMovie(time) }

    fun getTrendingTV(time: String) = wrapWithFlow { API.apiService.getTrendingTV(time) }

    fun getTrendingAll(time: String) = wrapWithFlow { API.apiService.getTrendingAll(time) }

    fun searchForMovie(movieTitle: String): Flow<State<MovieResponse?>> {
        return wrapWithFlow { API.apiService.searchForMovie(movieTitle) }
    }

    fun getGenres() = wrapWithFlow { API.apiService.getGenres(Constant.API_KEY) }

    fun getMoviesOfOneGenre(id: Int) = wrapWithFlow { API.apiService.getMoviesOfOneGenre(id) }

    fun getLatestTvShow() = wrapWithFlow { API.apiService.getLatestTvShow() }

    fun getTvShowChannel() = wrapWithFlow { API.apiService.getTvShowChannel() }

    fun getTvShowProvidersChannel() = wrapWithFlow { API.apiService.getTvShowProvidersChannel() }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {

                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }
}