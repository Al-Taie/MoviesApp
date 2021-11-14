package com.watermelon.moviesapp.ui.popular

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface PopularInteractionListener:BaseInteractionListener {
    fun onItemClick(id: Int)
}