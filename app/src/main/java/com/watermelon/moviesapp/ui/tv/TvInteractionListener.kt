package com.watermelon.moviesapp.ui.tv

import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.response.tv.TVResponse
import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface TvInteractionListener: BaseInteractionListener {
    fun onItemClicked(id: Int)
    fun setStream(state: State<TVResponse>?)
    fun refresh()
}