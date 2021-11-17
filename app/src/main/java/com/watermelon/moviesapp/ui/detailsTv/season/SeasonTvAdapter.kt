package com.watermelon.moviesapp.ui.detailsTv.season

import com.watermelon.moviesapp.model.response.tv.details.Season
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import watermelon.moviesapp.R


class SeasonTvAdapter (list: List<Season>, listener: HomeInteractionListener) :
    BaseAdapter<Season>(list, listener) {
    override var layoutID = R.layout.item_seasons
}