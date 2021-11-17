package com.watermelon.moviesapp.ui.home

import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class TradingMoviesAdapter (list: List<TrendingMovie>, listener: MovieInteractionListener) :
    BaseAdapter<TrendingMovie>(list, listener) {
    override var layoutID = R.layout.item_trending_movies
}