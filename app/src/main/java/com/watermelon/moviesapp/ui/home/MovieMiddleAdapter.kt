package com.watermelon.moviesapp.ui.home

import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class MovieMiddleAdapter(list: List<Movie>, listener: MovieInteractionListener) :
        BaseAdapter<Movie>(list, listener) {
        override val layoutID = R.layout.item_home_middle_recycler

}