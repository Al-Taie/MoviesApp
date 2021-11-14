package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.model.response.movie.MovieResponse
import com.watermelon.moviesapp.ui.categories.CategoriesInteractionListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CategoriesDisplayViewModel : ViewModel(), CategoriesInteractionListener {


    var movieDetails = MutableLiveData<State<MovieResponse?>>()

    override fun onItemClick(id: Int) {
        viewModelScope.launch {
            MovieRepository.getMoviesOfOneGenre(id).collect {
                movieDetails.postValue(it)
            }

        }
    }


}