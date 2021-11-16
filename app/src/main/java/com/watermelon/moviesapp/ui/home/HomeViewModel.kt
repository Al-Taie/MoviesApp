package com.watermelon.moviesapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository


class HomeViewModel : ViewModel(), MovieInteractionListener {
    val movies = MovieRepository.getMovies().asLiveData()
    val genres = MovieRepository.getGenres().asLiveData()
    val popularMovies = MovieRepository.getMoviesPopular().asLiveData()

    override fun onItemLoad(id: Int) {}

    override fun onCastClicked(personId: Int) {}

}