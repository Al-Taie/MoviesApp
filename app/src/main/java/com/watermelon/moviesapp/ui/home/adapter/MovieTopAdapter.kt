package com.watermelon.moviesapp.ui.home.adapter

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R

class MovieTopAdapter(list: List<Movie>, listener: MovieInteractionListener) :
        BaseAdapter<Movie>(list, listener) {
        override val layoutID = R.layout.item_home_top_recycler

}