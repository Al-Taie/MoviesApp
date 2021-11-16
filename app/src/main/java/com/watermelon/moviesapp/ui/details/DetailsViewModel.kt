package com.watermelon.moviesapp.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.SimilarResponse
import com.watermelon.moviesapp.model.response.credits.Credits
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel(), MovieInteractionListener {

    var movieDetails = MutableLiveData<State<Movie?>>()
    var credits = MutableLiveData<State<Credits?>>()
    var similarMovies = MutableLiveData<State<SimilarResponse?>>()
    private val _navigateToProfile = MutableLiveData<Event<Int>>()
    val navigateToProfile: LiveData<Event<Int>> = _navigateToProfile

   override fun onItemClicked(id : Int) = _navigateToProfile.postValue(Event(id))

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.run {
                getMovieDetails(id).collect { movieDetails.postValue(it) }
                getMovieCast(id).collect { credits.postValue(it) }
                getSimilarMovies(id).collect { similarMovies.postValue(it) }
            }
        }
    }

}