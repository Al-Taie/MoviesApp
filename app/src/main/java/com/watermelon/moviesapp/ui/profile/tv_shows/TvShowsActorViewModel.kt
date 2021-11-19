package com.watermelon.moviesapp.ui.profile.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.tvCredits.TvCreditsResponse
import com.watermelon.moviesapp.ui.base.BaseViewModel
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import com.watermelon.moviesapp.ui.profile.ProfileInteractionListener
import com.watermelon.moviesapp.utils.Event


class TvShowsActorViewModel : BaseViewModel(), ProfileInteractionListener {
    var tvCredits = MutableLiveData<State<TvCreditsResponse?>>()
    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    override fun onItemLoad(id: Int) {
        collectValue(MovieRepository.getTVCredits(id), tvCredits)
    }

    override fun onItemClicked(id: Int) = _navigateToDetails.postValue(Event(id))
}