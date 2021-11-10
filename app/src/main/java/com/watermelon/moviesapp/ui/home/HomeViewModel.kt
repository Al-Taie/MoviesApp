package com.watermelon.moviesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.utils.Event


class HomeViewModel : ViewModel(), MovieInteractionListener{
    val movies = MovieRepository.getMovies().asLiveData()
    val genres = MovieRepository.getGenres().asLiveData()

    override fun onItemLoad(id: Int) {

    }

    override fun onCastClicked(personId: Int) {
        // TODO("Not yet implemented")
    }

}