package com.watermelon.moviesapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository


class HomeViewModel : ViewModel(), MovieInteractionListener{
    val movies = MovieRepository.getMovies().asLiveData()
    val genres = MovieRepository.getGenres().asLiveData()

    override fun onItemLoad(id: Int) {
        // TODO("Not yet implemented")
    }

    override fun onCastClicked(personId: Int) {
        TODO("Not yet implemented")
    }

}