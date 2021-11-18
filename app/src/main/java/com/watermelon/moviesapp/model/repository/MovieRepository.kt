package com.watermelon.moviesapp.model.repository


import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.network.API
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object MovieRepository {
    fun getMovies() = wrapWithFlow { API.apiService.getMovies() }

    fun getMoviesPopular() = wrapWithFlow { API.apiService.getMoviePopular() }

    fun getMoviesUpcoming() = wrapWithFlow { API.apiService.getMovieUpcoming() }

    fun getMoviesTrading() = wrapWithFlow { API.apiService.getMoviesTrading() }

    fun getMoviesTopRated() = wrapWithFlow { API.apiService.getMoviesTopRated() }

    fun getMovieDetails(movieId: Int) = wrapWithFlow { API.apiService.getMovieDetails(movieId) }

    fun getMovieCast(movieId: Int) = wrapWithFlow { API.apiService.getMovieCast(movieId) }

    fun getProfile(id: Int) = wrapWithFlow { API.apiService.getProfile(id) }

    fun getMovieCredits(id: Int) = wrapWithFlow { API.apiService.getMovieCredits(id) }

    fun getTVCredits(id: Int) = wrapWithFlow { API.apiService.getTVCredits(id) }

    fun getSimilarMovies(id: Int) = wrapWithFlow { API.apiService.getSimilarMovies(id) }

    fun getSimilarTv(id: Int) = wrapWithFlow { API.apiService.getSimilarTv(id) }

    fun getTvCast(id: Int) = wrapWithFlow { API.apiService.getTvCast(id) }

    fun getTrendingPerson(time: String) = wrapWithFlow { API.apiService.getTrendingPerson(time) }

    fun getTrendingMovie(time: String) = wrapWithFlow { API.apiService.getTrendingMovie(time) }

    fun getTrendingTV(time: String) = wrapWithFlow { API.apiService.getTrendingTV(time) }

    fun getTrendingAll(time: String) = wrapWithFlow { API.apiService.getTrendingAll(time) }

    fun searchForMovie(movieTitle: String): Flow<State<MovieResponse?>> =
        wrapWithFlow { API.apiService.searchForMovie(movieTitle) }

    fun getGenres() = wrapWithFlow { API.apiService.getGenres(Constant.API_KEY) }

    fun getMoviesOfOneGenre(id: Int) = wrapWithFlow { API.apiService.getMoviesOfOneGenre(id) }

    fun getTvPopular() = wrapWithFlow { API.apiService.getTvPopular() }

    fun getTvTopRated() = wrapWithFlow { API.apiService.getTvTopRated() }

    fun getTvAiringToday() = wrapWithFlow { API.apiService.getTvAiringToday() }

    fun getTvOnTheAir() = wrapWithFlow { API.apiService.getTvOnTheAir() }

    fun getTvDetails(id: Int) = wrapWithFlow { API.apiService.getTvDetails(id) }

    fun getLatestTvShow() = wrapWithFlow { API.apiService.getLatestTvShow() }

    fun getTvShowChannel() = wrapWithFlow { API.apiService.getTvShowChannel() }

    fun getTvShowProvidersChannel() = wrapWithFlow { API.apiService.getTvShowProvidersChannel() }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {
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
        }.catch {
            emit(State.Error(it.message.toString()))
        }

}
