package com.watermelon.moviesapp.ui.home

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class UpcomingMoviesAdapter (list: List<Movie>, listener: MovieInteractionListener) :
    BaseAdapter<Movie>(list, listener) {
    override var layoutID = R.layout.item__movies
}