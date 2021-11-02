package com.watermelon.moviesapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository


class HomeViewModel : ViewModel(), MovieInteractionListener{
    val movies = MovieRepository.getMovies().asLiveData()
    override fun onItemClicked(movieId: Int) {
        // TODO("Not yet implemented")
    }

}