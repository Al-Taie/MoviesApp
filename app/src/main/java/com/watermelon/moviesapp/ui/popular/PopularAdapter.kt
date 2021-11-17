package com.watermelon.moviesapp.ui.popular

import com.watermelon.moviesapp.model.response.trending.person.TrendingPerson
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class PopularAdapter(list: List<TrendingPerson>, listener: PopularInteractionListener) :
    BaseAdapter<TrendingPerson>(list, listener) {

    override var layoutID = R.layout.item_famous_people
}