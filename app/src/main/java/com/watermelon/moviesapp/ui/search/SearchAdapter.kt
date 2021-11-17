package com.watermelon.moviesapp.ui.search

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import watermelon.moviesapp.R

class SearchAdapter(list: List<Movie>, listener: HomeInteractionListener) :
    BaseAdapter<Movie>(list, listener) {

    override var layoutID = R.layout.item_search
}




