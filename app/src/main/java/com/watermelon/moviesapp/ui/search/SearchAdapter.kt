package com.watermelon.moviesapp.ui.search

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R

class SearchAdapter(list: List<Movie>, listener: MovieInteractionListener) :
    BaseAdapter<Movie>(list, listener) {

    override val layoutID = R.layout.item_search_recycler_view
}




