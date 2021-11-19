package com.watermelon.moviesapp.ui.details

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface DetailsInteractionListener : BaseInteractionListener {
    fun onItemLoad(id: Int)
    fun onItemClicked(id: Int)
}