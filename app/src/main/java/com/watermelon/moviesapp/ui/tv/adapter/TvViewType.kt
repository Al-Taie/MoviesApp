package com.watermelon.moviesapp.ui.tv.adapter

import watermelon.moviesapp.R

enum class TvViewType(val id: Int) {
    TV_SEASON(R.layout.item_tv_parent_season),
    TV_CHANNEL(R.layout.item_tv_parent_channel),
    TV_CHANNEL_PROVIDERS(R.layout.item_tv_parent_providers_channel)
}