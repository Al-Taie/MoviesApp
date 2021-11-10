package com.watermelon.moviesapp.ui.tv

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface TvInteractionListener: BaseInteractionListener {
    fun onItemLoad(id: Int)
    fun onItemClicked(id: Int)
}