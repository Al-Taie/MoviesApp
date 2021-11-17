package com.watermelon.moviesapp.ui.detailsTv.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.tv.TVSimilarResponse
import com.watermelon.moviesapp.model.response.credits.Credits
import com.watermelon.moviesapp.model.response.tv.details.TVDetailsResponse
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import com.watermelon.moviesapp.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class DetailsTvViewModel : ViewModel(), MovieInteractionListener {

    var credits = MutableLiveData<State<Credits?>>()
    var similarTv = MutableLiveData<State<TVSimilarResponse?>>()
    private val _tvDetails = MutableLiveData<State<TVDetailsResponse?>>()
    val tvDetails: LiveData<State<TVDetailsResponse?>> = _tvDetails
    private val _navigateToProfile = MutableLiveData<Event<Int>>()
    val navigateToProfile: LiveData<Event<Int>> = _navigateToProfile

    override fun onItemClicked(id : Int) = _navigateToProfile.postValue(Event(id))

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.run {
                getTvDetails(id).collect { _tvDetails.postValue(it) }
                getTvCredits(id).collect { credits.postValue(it) }
                getSimilarTv(id).collect { similarTv.postValue(it) }
            }
        }
    }

}

