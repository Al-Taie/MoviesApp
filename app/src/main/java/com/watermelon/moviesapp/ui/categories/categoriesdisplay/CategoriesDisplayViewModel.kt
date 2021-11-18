package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import androidx.lifecycle.*
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CategoriesDisplayViewModel : ViewModel(), CategoriesDisplayInteractionListener {
    private val _movieOfOneGenre = MutableLiveData<State<MovieResponse?>>()
    val movieOfOneGenre: LiveData<State<MovieResponse?>> get() = _movieOfOneGenre

    private val _navigateToDetailsFromCategories = MutableLiveData<Event<Int>>()
    val navigateToDetailsFromCategories: LiveData<Event<Int>> = _navigateToDetailsFromCategories

    override fun onItemClick(id: Int) {
        _navigateToDetailsFromCategories.postValue(Event(id))
    }

    fun getMoviesOfOneGenre(id: Int) {
        viewModelScope.launch {
            MovieRepository.getMoviesOfOneGenre(id = id).collect { _movieOfOneGenre.postValue(it) }
        }
    }
}