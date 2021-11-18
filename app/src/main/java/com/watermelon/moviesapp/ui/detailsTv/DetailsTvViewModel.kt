package com.watermelon.moviesapp.ui.detailsTv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.tv.TVSimilarResponse
import com.watermelon.moviesapp.model.response.tv.details.TVDetailsResponse
import com.watermelon.moviesapp.model.response.tvCredits.TvCredits
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class DetailsTvViewModel : ViewModel(), TvDetailsInteractionListener {


    private val _credits = MutableLiveData<State<TvCredits?>>()
    val credits: LiveData<State<TvCredits?>> = _credits

    private val _similarTv = MutableLiveData<State<TVSimilarResponse?>>()
    val similarTv: LiveData<State<TVSimilarResponse?>> = _similarTv

    private val _tvDetails = MutableLiveData<State<TVDetailsResponse?>>()
    val tvDetails: LiveData<State<TVDetailsResponse?>> = _tvDetails
    private val _navigateToProfile = MutableLiveData<Event<Int>>()
    val navigateToProfile: LiveData<Event<Int>> = _navigateToProfile

    private val _navigateToItSelf = MutableLiveData<Event<Int>>()
    val navigateToItSelf: LiveData<Event<Int>> = _navigateToItSelf


    override fun onItemClicked(id: Int) = _navigateToProfile.postValue(Event(id))

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.run {
                getTvDetails(id).collect { _tvDetails.postValue(it) }
                getTvCredits(id).collect { _credits.postValue(it) }
                getSimilarTv(id).collect { _similarTv.postValue(it) }
            }
        }
    }
}

