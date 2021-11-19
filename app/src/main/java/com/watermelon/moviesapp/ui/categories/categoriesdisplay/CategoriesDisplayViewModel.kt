package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.utils.Event

class CategoriesDisplayViewModel : BaseViewModel(), CategoriesDisplayInteractionListener {
    private val _genreID = MutableLiveData(0)
    private val _movieOfOneGenre = MutableLiveData<State<MovieResponse?>>()
    val movieOfOneGenre: LiveData<State<MovieResponse?>> get() = _movieOfOneGenre

    private val _navigateToDetailsFromCategories = MutableLiveData<Event<Int>>()
    val navigateToDetailsFromCategories: LiveData<Event<Int>> = _navigateToDetailsFromCategories

    override fun onItemClick(id: Int) {
        _navigateToDetailsFromCategories.postValue(Event(id))
    }

    override fun refresh() { _genreID.value?.let { onLoad(it) } }

    fun onLoad(id: Int) {
        _genreID.postValue(id)
        collectValue(MovieRepository.getMoviesOfOneGenre(id = id), _movieOfOneGenre)
    }
}