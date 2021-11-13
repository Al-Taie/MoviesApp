package com.watermelon.moviesapp.ui.profile.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.ui.home.MovieInteractionListener


class TvShowsActorViewModel : ViewModel() , MovieInteractionListener {
    val tvShowChannel = MovieRepository.getTvShowChannel().asLiveData()

    override fun onItemLoad(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onCastClicked(personId: Int) {
        TODO("Not yet implemented")
    }
}