package com.watermelon.moviesapp.ui.trending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.utils.TimeWindow

class TrendingViewModel : ViewModel(), TrendingInteractionListener {
    val trendingPerson = MovieRepository.getTrendingPerson(TimeWindow.DAY).asLiveData()
    val trendingMovies = MovieRepository.getTrendingMovie(TimeWindow.DAY).asLiveData()
    val trendingTV = MovieRepository.getTrendingTV(TimeWindow.DAY).asLiveData()
    val trendingAll = MovieRepository.getTrendingAll(TimeWindow.WEEK).asLiveData()

    override fun onItemLoad(id: Int) {}

    override fun onItemClicked(id: Int) {}
}