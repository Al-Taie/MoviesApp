package com.watermelon.moviesapp.ui.details

import com.watermelon.moviesapp.model.response.movie.MovieSimilarResponse
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class SimilarMoviesAdapter (list: List<MovieSimilarResponse>, listener: HomeInteractionListener) :
    BaseAdapter<MovieSimilarResponse>(list, listener) {
    override var layoutID = R.layout.item_similar_movies
}