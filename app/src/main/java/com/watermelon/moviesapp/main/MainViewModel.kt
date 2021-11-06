package com.watermelon.moviesapp.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.watermelon.moviesapp.model.response.movie.Movie
import watermelon.moviesapp.BR
import watermelon.moviesapp.R

class MainViewModel : ViewModel() {
    val listSubject = MutableLiveData<List<Movie>>(listOf())
    val listRecyclerViewItem: LiveData<List<RecyclerItem>> = Transformations.map(listSubject) {
        it.map { that -> RecyclerItem(that, R.layout.item_movies_top_list, BR.data) }
        it.map { that -> RecyclerItem(that, R.layout.item_movies_top_list, BR.data) }
    }
}