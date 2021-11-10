package com.watermelon.moviesapp.ui.tv.adapter

import com.watermelon.moviesapp.model.response.providerstv.ProvidersTvResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.tv.TvInteractionListener
import watermelon.moviesapp.R

class TvChannelProvidersAdapter(list: List<ProvidersTvResponse>, listener: TvInteractionListener) :
    BaseAdapter<ProvidersTvResponse>(list, listener) {
    override var layoutID = R.layout.item_tv_child_providers_channel
}