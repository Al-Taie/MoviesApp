package com.watermelon.moviesapp.ui.famous

import com.watermelon.moviesapp.model.response.trending.person.TrendingPerson
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class FamousAdapter(list: List<TrendingPerson>, listener: FamousInteractionListener) :
    BaseAdapter<TrendingPerson>(list, listener) {

    override var layoutID = R.layout.item_famous_people
}