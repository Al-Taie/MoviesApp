package com.watermelon.moviesapp.ui.details

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface SimilarMovieListener : BaseInteractionListener {
    fun onSimilarMovieClicked(id : Int)
}