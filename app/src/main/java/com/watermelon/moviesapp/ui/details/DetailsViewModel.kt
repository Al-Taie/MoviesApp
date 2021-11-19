package com.watermelon.moviesapp.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.credits.Credits
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.model.response.movie.MovieSimilarResponse
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.utils.Event

class DetailsViewModel : BaseViewModel(), DetailsInteractionListener,
    SimilarInteractionListener {
    private val _movieID = MutableLiveData(0)
    var movieDetails = MutableLiveData<State<Movie?>>()
    var credits = MutableLiveData<State<Credits?>>()
    var similarMovies = MutableLiveData<State<MovieSimilarResponse?>>()

    private val _navigateToProfile = MutableLiveData<Event<Int>>()
    val navigateToProfile: LiveData<Event<Int>> = _navigateToProfile

    private val _navigateToItSelf = MutableLiveData<Event<Int>>()
    val navigateToItSelf: LiveData<Event<Int>> = _navigateToItSelf

    override fun onItemClicked(id: Int) = _navigateToProfile.postValue(Event(id))

    override fun refresh() { _movieID.value?.let { onItemLoad(it) } }

    override fun onSimilarItemClicked(id: Int) = _navigateToItSelf.postValue(Event(id))

    override fun onItemLoad(id: Int) {
        _movieID.postValue(id)
        MovieRepository.run {
            collectValue(getMovieDetails(id), movieDetails)
            collectValue(getMovieCast(id), credits)
            collectValue(getSimilarMovies(id), similarMovies)
        }
    }

}