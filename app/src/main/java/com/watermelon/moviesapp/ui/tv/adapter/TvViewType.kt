package com.watermelon.moviesapp.ui.tv.adapter

import watermelon.moviesapp.R

enum class TvViewType(val id: Int, val index: Int) {
    TV_SEASON(R.layout.item_tv_parent_season, 0),
    TV_CHANNEL(R.layout.item_tv_parent_channel, 1),
   // TV_CHANNEL_PROVIDERS(R.layout.item_tv_parent_providers_channel)
}