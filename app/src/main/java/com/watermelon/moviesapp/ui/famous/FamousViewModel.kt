package com.watermelon.moviesapp.ui.famous

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.trending.person.TrendingPersonResponse
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.utils.Event
import com.watermelon.moviesapp.utils.TimeWindow

class FamousViewModel : BaseViewModel(), FamousInteractionListener {
    val trendingPerson = MutableLiveData<State<TrendingPersonResponse?>>()

    private val _navigateToProfile = MutableLiveData<Event<Int>>()
    val navigateToProfile: LiveData<Event<Int>> = _navigateToProfile

    init {
        refresh()
    }

    override fun onItemClick(id: Int) {
        _navigateToProfile.postValue(Event(id))
    }

    override fun refresh() {
        collectValue(MovieRepository.getTrendingPerson(TimeWindow.DAY), trendingPerson)
    }
}