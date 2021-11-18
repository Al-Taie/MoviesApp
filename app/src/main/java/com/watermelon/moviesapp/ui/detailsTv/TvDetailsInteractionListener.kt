package com.watermelon.moviesapp.ui.detailsTv

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface TvDetailsInteractionListener:BaseInteractionListener {
    fun onItemLoad(id: Int)
    fun onItemClicked(id : Int)
    fun onSimilarItemClicked(id : Int)
}