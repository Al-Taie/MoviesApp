package com.watermelon.moviesapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(), SearchInteractionListener {
    val movieTitle = MutableLiveData<String?>()
    var movieSearchResult = MutableLiveData<State<MovieResponse?>>()
    var movieDetails = MutableLiveData<State<Movie?>>()

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    fun clearText() {
        movieTitle.postValue("")
    }

    fun searchForMovie() {
        viewModelScope.launch {
            movieTitle.value.toString().takeIf { it.isNotEmpty() }?.let { title ->
                MovieRepository.searchForMovie(title).collect { movieSearchResult.postValue(it) }
            }
        }
    }

    override fun onItemLoad(id: Int) {
        _navigateToDetails.postValue(Event(id))

        viewModelScope.launch {
            MovieRepository.getMovieDetails(id).collect { movieDetails.postValue(it) }
        }
    }
}