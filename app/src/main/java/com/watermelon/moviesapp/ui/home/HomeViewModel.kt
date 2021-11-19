package com.watermelon.moviesapp.ui.home

import androidx.lifecycle.*
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovieResponse
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.utils.Event


class HomeViewModel : BaseViewModel(), HomeInteractionListener {
    val popularMovies = MutableLiveData<State<MovieResponse?>>()
    val upcomingMovies = MutableLiveData<State<MovieResponse?>>()
    val tradingMovies = MutableLiveData<State<TrendingMovieResponse?>>()
    val topRatedMovies = MutableLiveData<State<MovieResponse?>>()

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    init {
        refresh()
    }

    override fun onItemClicked(id: Int) = _navigateToDetails.postValue(Event(id))

    override fun refresh() {
        collectValue(MovieRepository.getMoviesPopular(), popularMovies)
        collectValue(MovieRepository.getMoviesUpcoming(), upcomingMovies)
        collectValue(MovieRepository.getMoviesTrading(), tradingMovies)
        collectValue(MovieRepository.getMoviesTopRated(), topRatedMovies)
    }

    override fun onItemLoad(id: Int) {}
}