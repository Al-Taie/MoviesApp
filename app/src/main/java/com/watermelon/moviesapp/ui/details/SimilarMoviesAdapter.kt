package com.watermelon.moviesapp.ui.details

import com.watermelon.moviesapp.model.response.movie.MovieSimilarResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R

class SimilarMoviesAdapter (list: List<MovieSimilarResponse>, listener: MovieInteractionListener) :
    BaseAdapter<MovieSimilarResponse>(list, listener) {
    override var layoutID = R.layout.item_similar_movies
}