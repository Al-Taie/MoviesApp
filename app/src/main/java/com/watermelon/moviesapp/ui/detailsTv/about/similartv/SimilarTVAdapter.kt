package com.watermelon.moviesapp.ui.detailsTv.about.similartv

import com.watermelon.moviesapp.model.response.tv.TVSimilarResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.detailsTv.TvDetailsInteractionListener
import watermelon.moviesapp.R

class SimilarTVAdapter(list: List<TVSimilarResponse>, listener: TvDetailsInteractionListener) :
    BaseAdapter<TVSimilarResponse>(list, listener) {
    override var layoutID = R.layout.item_similar_tv
}