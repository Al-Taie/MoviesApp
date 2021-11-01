package com.watermelon.moviesapp.ui.home

import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface MovieInteractionListener : BaseInteractionListener {
    fun onItemClicked(movie :Movie)
}
