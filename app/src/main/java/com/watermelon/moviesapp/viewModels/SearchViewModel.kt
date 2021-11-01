package com.watermelon.moviesapp.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.model.response.MovieResponse
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(),MovieInteractionListener {


    val movieTitle = MutableLiveData<String?>()

    var movieSearchResult = MutableLiveData<State<MovieResponse?>>()



    fun searchForMovie() {

        viewModelScope.launch {
            MovieRepository.searchForMovie(movieTitle.value.toString()).collect{
                movieSearchResult.postValue(it)
            }
        }
    }

    override fun onItemClicked(movie: Movie) {
        movie.id?.let {
            Log.i("eee",it.toString())

           MovieRepository.getMovieDetails(it) }


    }
}