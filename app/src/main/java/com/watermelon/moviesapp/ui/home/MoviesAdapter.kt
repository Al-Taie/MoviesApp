package com.watermelon.moviesapp.ui.home

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class MoviesAdapter (list: List<Movie>, listener: HomeInteractionListener) :
    BaseAdapter<Movie>(list, listener) {
    override var layoutID = R.layout.item_movies
}