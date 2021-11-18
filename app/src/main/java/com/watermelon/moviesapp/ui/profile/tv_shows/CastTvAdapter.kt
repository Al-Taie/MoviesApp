package com.watermelon.moviesapp.ui.profile.tv_shows

import com.watermelon.moviesapp.model.response.tvCredits.Cast
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.profile.ProfileInteractionListener
import watermelon.moviesapp.R

class CastTvAdapter(list: List<Cast>, listener: ProfileInteractionListener) :
    BaseAdapter<Cast>(list, listener) {

    override var layoutID = R.layout.item_tv_credits_actor
}