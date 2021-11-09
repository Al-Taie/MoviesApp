package com.watermelon.moviesapp.ui.trending.adapter

import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.trending.TrendingInteractionListener
import watermelon.moviesapp.R

class TrendingMovieAdapter(list: List<TrendingMovie>, listener: TrendingInteractionListener) :
        BaseAdapter<TrendingMovie>(list, listener) {
        override var layoutID = R.layout.item_trending_child_movie
}