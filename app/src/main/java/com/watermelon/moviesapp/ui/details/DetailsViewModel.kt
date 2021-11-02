package com.watermelon.moviesapp.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel(), MovieInteractionListener {

    var movieDetails = MutableLiveData<State<Movie?>>()

    override fun onItemClicked(movieId: Int) {
        viewModelScope.launch {
            MovieRepository.getMovieDetails(movieId).collect {
                movieDetails.postValue(it)
            }
        }
    }
}