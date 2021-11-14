package com.watermelon.moviesapp.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.tv.TVResponse
import com.watermelon.moviesapp.utils.Event

class TvViewModel : ViewModel(), TvInteractionListener {
    val topRated = MovieRepository.getTvTopRated().asLiveData()
    val onTheAir = MovieRepository.getTvOnTheAir().asLiveData()
    val airingToday = MovieRepository.getTvAiringToday().asLiveData()
    val popular = MovieRepository.getTvPopular().asLiveData()
    val stream: MutableLiveData<State<TVResponse?>> = MutableLiveData()

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    override fun onItemClicked(id: Int) = _navigateToDetails.postValue(Event(id))

    override fun setStream(state: State<TVResponse>?) = stream.postValue(state)
}