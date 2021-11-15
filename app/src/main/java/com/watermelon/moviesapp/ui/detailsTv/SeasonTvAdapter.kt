package com.watermelon.moviesapp.ui.detailsTv

import com.watermelon.moviesapp.model.response.tv.details.Season
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R


class SeasonTvAdapter (list: List<Season>, listener: SeasonTvInteractionListener) :
    BaseAdapter<Season>(list, listener) {
    override var layoutID = R.layout.item_seasons
}