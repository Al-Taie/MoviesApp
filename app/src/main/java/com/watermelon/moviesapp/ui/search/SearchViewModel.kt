package com.watermelon.moviesapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.utils.Event

class SearchViewModel : BaseViewModel(), SearchInteractionListener {

    val movieTitle = MutableLiveData<String?>()
    var movieSearchResult = MutableLiveData<State<MovieResponse?>>()
    var movieDetails = MutableLiveData<State<Movie?>>()

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    fun clearText() {
        movieTitle.postValue("")
    }

    fun searchForMovie() {
        collectValue(MovieRepository.searchForMovie(movieTitle.value.toString()), movieSearchResult)
    }

    override fun onItemLoad(id: Int) {
        _navigateToDetails.postValue(Event(id))
        collectValue(MovieRepository.getMovieDetails(id), movieDetails)
    }

}