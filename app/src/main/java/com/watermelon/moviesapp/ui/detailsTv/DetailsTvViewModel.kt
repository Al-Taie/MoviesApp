package com.watermelon.moviesapp.ui.detailsTv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.SimilarResponse
import com.watermelon.moviesapp.model.response.credits.Credits
import com.watermelon.moviesapp.model.response.tv.details.TVDetailsResponse
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class DetailsTvViewModel : ViewModel(), MovieInteractionListener, SeasonTvInteractionListener {

    var credits = MutableLiveData<State<Credits?>>()
    var similarTv = MutableLiveData<State<SimilarResponse?>>()
    private val _tvDetails = MutableLiveData<State<TVDetailsResponse?>>()
    val tvDetails: LiveData<State<TVDetailsResponse?>> = _tvDetails
    var displayData: MutableLiveData<Boolean> = MutableLiveData()
    var isDisplayData = false

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.run {
                getTvDetails(id).collect { _tvDetails.postValue(it) }
                getTvCredits(id).collect { credits.postValue(it) }
                getSimilarTv(id).collect { similarTv.postValue(it) }
            }
        }
    }

    override fun onCastClicked(personId: Int) {}

    override fun onClickToDisplayData() {
        displayData.postValue(!isDisplayData)
    }

}

