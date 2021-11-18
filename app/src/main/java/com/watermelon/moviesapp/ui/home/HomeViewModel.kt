package com.watermelon.moviesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.utils.Event


class HomeViewModel : ViewModel(), HomeInteractionListener {

    val popularMovies = MovieRepository.getMoviesPopular().asLiveData()
    val upcomingMovies = MovieRepository.getMoviesUpcoming().asLiveData()
    val tradingMovies = MovieRepository.getMoviesTrading().asLiveData()
    val topRatedMovies = MovieRepository.getMoviesTopRated().asLiveData()

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails
    override fun onItemClicked(id: Int) = _navigateToDetails.postValue(Event(id))

    override fun onItemLoad(id: Int) {}
}