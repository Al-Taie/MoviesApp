package com.watermelon.moviesapp.ui.detailsTv

import com.watermelon.moviesapp.model.response.tv.TVSimilarResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.R

class SimilarTVAdapter (list: List<TVSimilarResponse>, listener: MovieInteractionListener) :
    BaseAdapter<TVSimilarResponse>(list, listener) {
    override var layoutID = R.layout.item_similar_tv
}