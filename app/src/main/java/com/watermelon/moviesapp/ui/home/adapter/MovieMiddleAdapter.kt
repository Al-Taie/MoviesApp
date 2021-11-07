package com.watermelon.moviesapp.ui.home.adapter

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R

class MovieMiddleAdapter(list: List<Movie>, listener: MovieInteractionListener) :
        BaseAdapter<Movie>(list, listener) {
        override var layoutID = R.layout.item_home_middle_recycler

}