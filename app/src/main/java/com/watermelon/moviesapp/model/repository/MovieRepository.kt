package com.watermelon.moviesapp.model.repository


import android.util.Log
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.network.API
import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.model.response.MovieResponse
import com.watermelon.moviesapp.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object MovieRepository {
    fun getMovies() = wrapWithFlow { API.apiService.getMovies() }

    fun searchForMovie(movieTitle:String):Flow<State<MovieResponse?>>{

        return wrapWithFlow { API.apiService.searchForMovie(Constant.API_kEY,movieTitle) }
    }


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