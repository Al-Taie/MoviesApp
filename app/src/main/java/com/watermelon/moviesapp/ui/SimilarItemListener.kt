package com.watermelon.moviesapp.ui

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface SimilarItemListener : BaseInteractionListener {
    fun onSimilarItemClicked(id : Int)
}