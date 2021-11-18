package com.watermelon.moviesapp.ui.profile.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movieCredits.MovieCredits
import com.watermelon.moviesapp.ui.profile.ProfileInteractionListener
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesActorViewModel : ViewModel(), ProfileInteractionListener {
    var movieCredits = MutableLiveData<State<MovieCredits?>>()
    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    override fun onItemClicked(id: Int) = _navigateToDetails.postValue(Event(id))

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.getMovieCredits(id).collect {
                movieCredits.postValue(it)
            }
        }
    }
}