package com.watermelon.moviesapp.ui.tv.adapter

import com.watermelon.moviesapp.model.response.channel.ChannelResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.tv.TvInteractionListener
import watermelon.moviesapp.R

class TvChannelAdapter(list: List<ChannelResponse>, listener: TvInteractionListener) :
    BaseAdapter<ChannelResponse>(list, listener) {
    override var layoutID = R.layout.item_tv_child_channel
}