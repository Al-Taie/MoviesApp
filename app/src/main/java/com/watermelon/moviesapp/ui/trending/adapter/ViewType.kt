package com.watermelon.moviesapp.ui.trending.adapter

import watermelon.moviesapp.R

enum class ViewType(val id: Int, val index: Int) {
    ALL(R.layout.item_trending_parent_all, 0),
    MOVIE(R.layout.item_trending_parent_movie, 1),
    PERSON(R.layout.item_trending_parent_person, 2),
    TV(R.layout.item_trending_parent_tv, 3)

}
