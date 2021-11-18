package com.watermelon.moviesapp.ui.detailsTv.about

import com.watermelon.moviesapp.model.response.tvCredits.Cast
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.detailsTv.TvDetailsInteractionListener
import watermelon.moviesapp.R

class CastTvAdapter(list: List<Cast>, listener: TvDetailsInteractionListener) :
    BaseAdapter<Cast>(list, listener) {
    override var layoutID = R.layout.item_tv_actor
}