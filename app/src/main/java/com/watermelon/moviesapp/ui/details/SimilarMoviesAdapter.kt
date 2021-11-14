package com.watermelon.moviesapp.ui.details

import com.watermelon.moviesapp.model.response.SimilarResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R

class SimilarMoviesAdapter (list: List<SimilarResponse>, listener: MovieInteractionListener) :
    BaseAdapter<SimilarResponse>(list, listener) {
    override var layoutID = R.layout.item_similar_movies
}