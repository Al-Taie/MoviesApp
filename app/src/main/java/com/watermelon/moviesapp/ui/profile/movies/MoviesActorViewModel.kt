package com.watermelon.moviesapp.ui.profile.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movieCredits.MovieCredits
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesActorViewModel : ViewModel(),MovieInteractionListener {
    var movieCredits = MutableLiveData<State<MovieCredits?>>()

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {

            MovieRepository.getMovieCredits(id).collect {
                movieCredits.postValue(it)
            }
        }
    }

    override fun onCastClicked(personId: Int) {
    }
}