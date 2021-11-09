package com.watermelon.moviesapp.ui.genres

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GenreViewModel  : ViewModel(), MovieInteractionListener {
    val moviesOfOneGenre =  MutableLiveData<State<MovieResponse?>>()

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.getMoviesOfOneGenre(id).collect {
                moviesOfOneGenre.postValue(it)
            }
        }
    }

    override fun onCastClicked(personId: Int) {
        TODO("Not yet implemented")
    }
}