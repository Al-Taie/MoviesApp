package com.watermelon.moviesapp.ui.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.watermelon.moviesapp.model.repository.MovieRepository

class CategoriesViewModel : ViewModel(),CategoriesInteractionListener{

    val genres = MovieRepository.getGenres().asLiveData()











    override fun onItemClick(id: Int) {

    }


}