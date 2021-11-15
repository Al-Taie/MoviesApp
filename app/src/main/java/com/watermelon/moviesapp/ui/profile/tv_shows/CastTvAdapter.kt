package com.watermelon.moviesapp.ui.profile.tv_shows

import com.watermelon.moviesapp.model.response.tvCredits.Cast
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R

class CastTvAdapter (list: List<Cast>, listener: MovieInteractionListener) :
    BaseAdapter<Cast>(list, listener) {

    override var layoutID = R.layout.item_tv_actor
}