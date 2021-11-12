package com.watermelon.moviesapp.ui.trending.adapter

import com.watermelon.moviesapp.model.response.trending.tv.TrendingTV
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.trending.TrendingInteractionListener
import watermelon.moviesapp.R

class TrendingTVAdapter(list: List<TrendingTV>, listener: TrendingInteractionListener) :
        BaseAdapter<TrendingTV>(list, listener) {
        override var layoutID = R.layout.item_categories
}