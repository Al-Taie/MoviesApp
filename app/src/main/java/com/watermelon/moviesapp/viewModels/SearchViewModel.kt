package com.watermelon.moviesapp.viewModels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.model.response.MovieResponse
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import com.watermelon.moviesapp.ui.search.SearchFragment
import com.watermelon.moviesapp.ui.search.SearchFragmentDirections
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import watermelon.moviesapp.R

class SearchViewModel : ViewModel(),MovieInteractionListener {


    val movieTitle = MutableLiveData<String?>()

    var movieSearchResult = MutableLiveData<State<MovieResponse?>>()
    var movieDetails = MutableLiveData<State<Movie?>>()


    private val _openTaskEvent = MutableLiveData<Event<String>>()
    val openTaskEvent: LiveData<Event<String>> = _openTaskEvent

    fun searchForMovie() {

        viewModelScope.launch {
            MovieRepository.searchForMovie(movieTitle.value.toString()).collect{
                movieSearchResult.postValue(it)
            }
        }
    }

    override fun onItemClicked(movie: Movie) {
        viewModelScope.launch {
            MovieRepository.getMovieDetails(movie.id!!).collect {
                movieDetails.postValue(it)
                Log.i("details",it.toString())
            }
        }
    }
}