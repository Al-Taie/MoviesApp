package com.watermelon.moviesapp.model.repository


import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.network.API
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object MovieRepository {
    fun getMovies() = wrapWithFlow { API.apiService.getMovies(Constant.API_kEY) }
    fun getMovieDetails(movieId : Int) = wrapWithFlow { API.apiService.getMovieDetails(movieId,Constant.API_kEY) }
    fun getMovieCast(movieId : Int) = wrapWithFlow { API.apiService.getMovieCast(movieId,Constant.API_kEY) }

    fun getProfile(id: Int) = wrapWithFlow { API.apiService.getProfile(id, Constant.API_kEY) }

    fun getTrendingPerson(mediaType: String, time: String) = wrapWithFlow {
        API.apiService.getTrendingPerson(mediaType, time)
    }

    fun getTrendingMovie(mediaType: String, time: String) = wrapWithFlow {
        API.apiService.getTrendingMovie(mediaType, time)
    }

    fun getTrendingTV(mediaType: String, time: String) = wrapWithFlow {
        API.apiService.getTrendingTV(mediaType, time)
    }

    fun getTrendingAll(mediaType: String, time: String) = wrapWithFlow {
        API.apiService.getTrendingAll(mediaType, time)
    }

    fun searchForMovie(movieTitle:String):Flow<State<MovieResponse?>>{

        return wrapWithFlow { API.apiService.searchForMovie(Constant.API_kEY,movieTitle) }
    }
    fun getGenres() = wrapWithFlow { API.apiService.getGenres(Constant.API_kEY) }
    fun getLatestTvShow() = wrapWithFlow { API.apiService.getLatestTvShow(Constant.API_kEY) }

    private fun <T> wrapWithFlow(function : suspend () -> Response<T>) : Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful){

                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (e:Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }
}