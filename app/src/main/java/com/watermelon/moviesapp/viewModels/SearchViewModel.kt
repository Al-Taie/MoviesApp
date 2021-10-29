package com.watermelon.moviesapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(),MovieInteractionListener {


    var searchMovieTitle = MutableLiveData<String>()

    var movieSearchResult = MutableLiveData<State<Movie?>>()

    fun searchForMovie() {

        viewModelScope.launch {
            MovieRepository.searchForMovie(searchMovieTitle.value.toString()).collect{
                movieSearchResult.postValue(it)
            }
        }
    }

    override fun onItemClicked() {

    }
}