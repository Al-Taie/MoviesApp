package com.watermelon.moviesapp.ui.tv.adapter


import com.watermelon.moviesapp.model.response.tv.Season
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.tv.TvInteractionListener
import watermelon.moviesapp.R

class TvSeasonAdapter(list: List<Season>, listener: TvInteractionListener) :
    BaseAdapter<Season>(list, listener) {
    override var layoutID = R.layout.item_tv_child_season
}