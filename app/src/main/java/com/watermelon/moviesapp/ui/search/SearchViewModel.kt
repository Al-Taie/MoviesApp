package com.watermelon.moviesapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(),MovieInteractionListener {


    val movieTitle = MutableLiveData<String?>()

    var movieSearchResult = MutableLiveData<State<MovieResponse?>>()



    fun searchForMovie() {

        viewModelScope.launch {
            MovieRepository.searchForMovie(movieTitle.value.toString()).collect{
                movieSearchResult.postValue(it)
                Log.i("result",it.toString())
            }
        }
    }

    override fun onItemClicked() {

    }
}