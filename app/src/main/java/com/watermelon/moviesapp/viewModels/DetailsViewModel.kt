package com.watermelon.moviesapp.viewModels

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel(), MovieInteractionListener {

    var movieDetails = MutableLiveData<State<Movie?>>()

//    viewModelScope.launch {
//        MovieRepository.getMovieDetails(movie.id!!).collect {
//            movieDetails.postValue(it)
//            Log.i("details",it.toString())
//        }
//    }
    override fun onItemClicked(movie: Movie) {
        viewModelScope.launch {
            MovieRepository.getMovieDetails(movie.id!!).collect {
                movieDetails.postValue(it)
                Log.i("details",it.toString())
            }
        }
    }

}