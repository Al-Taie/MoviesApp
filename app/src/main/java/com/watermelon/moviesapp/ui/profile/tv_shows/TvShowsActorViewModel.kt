package com.watermelon.moviesapp.ui.profile.tv_shows

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.tvCredits.TvCreditsResponse
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TvShowsActorViewModel : ViewModel() , HomeInteractionListener {
    var tvCredits = MutableLiveData<State<TvCreditsResponse?>>()

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.getTVCredits(id).collect {
                tvCredits.postValue(it)
            }
        }
    }

    override fun onItemClicked(id: Int) {  }

}