package com.watermelon.moviesapp.ui.profile

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface ProfileInteractionListener : BaseInteractionListener {
    fun onItemClicked(id: Int)
}
