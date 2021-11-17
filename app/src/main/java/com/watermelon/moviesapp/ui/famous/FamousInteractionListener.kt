package com.watermelon.moviesapp.ui.famous

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface FamousInteractionListener:BaseInteractionListener {
    fun onItemClick(id: Int)
}