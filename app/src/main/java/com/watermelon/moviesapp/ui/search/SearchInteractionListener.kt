package com.watermelon.moviesapp.ui.search

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface SearchInteractionListener:BaseInteractionListener {
    fun onItemLoad(id: Int)
}