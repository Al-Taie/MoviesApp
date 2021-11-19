package com.watermelon.moviesapp.ui.profile.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movieCredits.MovieCredits
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import com.watermelon.moviesapp.utils.Event


class MoviesActorViewModel : BaseViewModel(), HomeInteractionListener {
    var movieCredits = MutableLiveData<State<MovieCredits?>>()
    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    override fun onItemClicked(id: Int) = _navigateToDetails.postValue(Event(id))


    override fun onItemLoad(id: Int) {
        collectValue(MovieRepository.getMovieCredits(id), movieCredits)
    }

}