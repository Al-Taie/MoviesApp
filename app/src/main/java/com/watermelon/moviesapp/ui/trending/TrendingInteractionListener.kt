package com.watermelon.moviesapp.ui.trending

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface TrendingInteractionListener : BaseInteractionListener {
    fun onItemLoad(id: Int)
    fun onItemClicked(id: Int)
}
