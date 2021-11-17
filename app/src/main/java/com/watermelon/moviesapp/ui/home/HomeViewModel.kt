package com.watermelon.moviesapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository


class HomeViewModel : ViewModel(), MovieInteractionListener {
    val movies = MovieRepository.getMovies().asLiveData()
    val genres = MovieRepository.getGenres().asLiveData()
    val popularMovies = MovieRepository.getMoviesPopular().asLiveData()
    val upcomingMovies = MovieRepository.getMoviesUpcoming().asLiveData()
    val tradingMovies = MovieRepository.getMoviesTrading().asLiveData()
    val topRatedMovies = MovieRepository.getMoviesTopRated().asLiveData()

    override fun onItemLoad(id: Int) {}

    override fun onItemClicked(id: Int) {}

}