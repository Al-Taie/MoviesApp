package com.watermelon.moviesapp.ui.trending.adapter

import com.watermelon.moviesapp.model.response.trending.person.TrendingPerson
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.trending.TrendingInteractionListener
import watermelon.moviesapp.R

class TrendingPersonAdapter(list: List<TrendingPerson>, listener: TrendingInteractionListener) :
    BaseAdapter<TrendingPerson>(list, listener) {
    override var layoutID = R.layout.item_trending_child_person
}