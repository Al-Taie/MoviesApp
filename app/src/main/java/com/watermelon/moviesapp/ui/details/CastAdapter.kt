package com.watermelon.moviesapp.ui.details

import com.watermelon.moviesapp.model.response.credits.Cast
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import watermelon.moviesapp.R

class CastAdapter(list: List<Cast>, listener: HomeInteractionListener) :
    BaseAdapter<Cast>(list, listener) {
    override var layoutID = R.layout.item_cast
}