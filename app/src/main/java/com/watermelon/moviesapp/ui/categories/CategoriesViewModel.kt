package com.watermelon.moviesapp.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.genres.Genres
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.utils.Event

class CategoriesViewModel : BaseViewModel(), CategoriesInteractionListener {
    val genres = MutableLiveData<State<Genres?>>()

    private val _navigateToCategoriesDisplay = MutableLiveData<Event<Int>>()
    val navigateToCategoriesDisplay: LiveData<Event<Int>> = _navigateToCategoriesDisplay

    init {
        refresh()
    }

    override fun onItemClick(id: Int) {
        _navigateToCategoriesDisplay.postValue(Event(id))
    }

    override fun refresh() {
        collectValue(MovieRepository.getGenres(), genres)
    }


}