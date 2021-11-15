package com.watermelon.moviesapp.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.utils.TimeWindow

class PopularViewModel : ViewModel(), PopularInteractionListener {


    val trendingPerson = MovieRepository.getTrendingPerson(TimeWindow.DAY).asLiveData()

    override fun onItemClick(id: Int) {

    }

}