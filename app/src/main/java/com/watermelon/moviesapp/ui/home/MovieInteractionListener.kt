package com.watermelon.moviesapp.ui.home

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface MovieInteractionListener : BaseInteractionListener {
    fun onItemLoad(id: Int)
    fun onItemClicked(id : Int)
}
