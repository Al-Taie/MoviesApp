package com.watermelon.moviesapp.ui.trending.adapter

import com.watermelon.moviesapp.model.response.trending.all.TrendingAll
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.trending.TrendingInteractionListener
import watermelon.moviesapp.R

class TrendingAllAdapter(list: List<TrendingAll>, listener: TrendingInteractionListener) :
        BaseAdapter<TrendingAll>(list, listener) {
        override var layoutID = R.layout.item_trending_child_all
}