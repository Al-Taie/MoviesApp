package com.watermelon.moviesapp.ui.home.adapter

import com.watermelon.moviesapp.main.MainViewModel
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.model.response.movies.Movies
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeViewModel
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.BR
import watermelon.moviesapp.R

class MovieTopAdapter(list: List<Movies>, listener: MovieInteractionListener) :
        BaseAdapter<Movies>(list, listener) {
        override var layoutID = R.layout.item_home_top_recycler
}