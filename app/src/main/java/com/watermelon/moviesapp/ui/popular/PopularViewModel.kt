package com.watermelon.moviesapp.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.utils.Event
import com.watermelon.moviesapp.utils.TimeWindow

class PopularViewModel : ViewModel(), PopularInteractionListener {


    val trendingPerson = MovieRepository.getTrendingPerson(TimeWindow.DAY).asLiveData()

    private val _navigateToProfile = MutableLiveData<Event<Int>>()
    val navigateToProfile: LiveData<Event<Int>> = _navigateToProfile

    override fun onItemClick(id: Int) {
        _navigateToProfile.postValue(Event(id))

    }

}