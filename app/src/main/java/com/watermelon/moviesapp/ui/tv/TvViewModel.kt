package com.watermelon.moviesapp.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.tv.TVResponse
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.utils.Event

class TvViewModel : BaseViewModel(), TvInteractionListener {
    val topRated = MutableLiveData<State<TVResponse?>>()
    val onTheAir = MutableLiveData<State<TVResponse?>>()
    val airingToday = MutableLiveData<State<TVResponse?>>()
    val popular = MutableLiveData<State<TVResponse?>>()
    val stream: MutableLiveData<State<TVResponse?>> = MutableLiveData()

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    init {
        refresh()
    }

    override fun onItemClicked(id: Int) = _navigateToDetails.postValue(Event(id))

    override fun setStream(state: State<TVResponse>?) { state?.let { stream.postValue(it) } }

    override fun refresh() {
        MovieRepository.run {
            collectValue(getTvTopRated(), topRated)
            collectValue(getTvOnTheAir(), onTheAir)
            collectValue(getTvAiringToday(), airingToday)
            collectValue(getTvPopular(), popular)
        }
    }
}