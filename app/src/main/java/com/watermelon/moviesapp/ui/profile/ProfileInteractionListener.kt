package com.watermelon.moviesapp.ui.profile

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface ProfileInteractionListener : BaseInteractionListener {
    fun onItemLoad(id: Int)
    fun onItemClicked(id : Int)
}