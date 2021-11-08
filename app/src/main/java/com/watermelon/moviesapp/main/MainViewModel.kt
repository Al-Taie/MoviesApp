package com.watermelon.moviesapp.main

import androidx.lifecycle.*
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.BR
import watermelon.moviesapp.R

class MainViewModel : ViewModel(), MovieInteractionListener {
    val movies = MovieRepository.getMovies().asLiveData()
    val genres = MovieRepository.getGenres().asLiveData()

    override fun onItemLoad(id: Int) {
        // TODO("Not yet implemented")
    }

    override fun onCastClicked(personId: Int) {
        // TODO("Not yet implemented")
    }
}