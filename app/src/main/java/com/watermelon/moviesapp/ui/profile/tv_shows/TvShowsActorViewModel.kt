package com.watermelon.moviesapp.ui.profile.tv_shows

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.credits.Credits
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TvShowsActorViewModel : ViewModel() , MovieInteractionListener {
    var tvCredits = MutableLiveData<State<Credits?>>()

    override fun onItemLoad(id: Int) {
        viewModelScope.launch {
            MovieRepository.getTvCredits(id).collect {
                tvCredits.postValue(it)
            }
        }
    }

    override fun onItemClicked(id: Int) {  }

}