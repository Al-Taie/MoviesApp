package com.watermelon.moviesapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(), MovieInteractionListener{
    val movieTitle = MutableLiveData<String?>()
    var movieSearchResult = MutableLiveData<State<MovieResponse?>>()
    var movieDetails = MutableLiveData<State<Movie?>>()

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    fun searchForMovie() {

        viewModelScope.launch {
            MovieRepository.searchForMovie(movieTitle.value.toString()).collect{
                movieSearchResult.postValue(it)
            }
        }
    }

    override fun onItemClicked(movieId: Int) {
        _navigateToDetails.postValue(Event(movieId))

        viewModelScope.launch {
            MovieRepository.getMovieDetails(movieId).collect {
                movieDetails.postValue(it)
            }
        }
    }
}