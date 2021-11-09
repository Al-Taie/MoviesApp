package com.watermelon.moviesapp.ui.trending.adapter

import watermelon.moviesapp.R

enum class ViewType(val id: Int) {
    PERSON(R.layout.item_trending_parent_person),
    MOVIE(R.layout.item_trending_parent_movie),
    TV(R.layout.item_trending_parent_tv),
    ALL(R.layout.item_trending_parent_all)
}
