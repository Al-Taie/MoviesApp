package com.watermelon.moviesapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository


class HomeViewModel : ViewModel() {
    val movies = MovieRepository.getMovies().asLiveData()
}