package com.watermelon.moviesapp.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.utils.Event

class CategoriesViewModel : ViewModel(),CategoriesInteractionListener{

    val genres = MovieRepository.getGenres().asLiveData()

    private val _navigateToCategoriesDisplay = MutableLiveData<Event<Int>>()
    val navigateToCategoriesDisplay: LiveData<Event<Int>> = _navigateToCategoriesDisplay


    override fun onItemClick(id: Int) {
        _navigateToCategoriesDisplay.postValue(Event(id))
    }


}