package com.watermelon.moviesapp.ui.details

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface SimilarInteractionListener : BaseInteractionListener {
    fun onSimilarItemClicked(id: Int)
}