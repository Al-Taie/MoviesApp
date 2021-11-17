package com.watermelon.moviesapp.ui.detailsTv

import com.watermelon.moviesapp.model.response.tv.TVSimilarResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import watermelon.moviesapp.R

class SimilarTVAdapter (list: List<TVSimilarResponse>, listener: HomeInteractionListener) :
    BaseAdapter<TVSimilarResponse>(list, listener) {
    override var layoutID = R.layout.item_similar_tv
}