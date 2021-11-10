package com.watermelon.moviesapp.ui.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository

class TvViewModel:ViewModel(),TvInteractionListener {


    val latestTvShow = MovieRepository.getLatestTvShow().asLiveData()

    val tvShowChannel = MovieRepository.getTvShowChannel().asLiveData()

    val getTvShowProvidersChannel = MovieRepository.getTvShowProvidersChannel().asLiveData()


    override fun onItemLoad(id: Int) {}

    override fun onItemClicked(id: Int) { }
}