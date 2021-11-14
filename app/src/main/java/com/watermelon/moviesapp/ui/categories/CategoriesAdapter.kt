package com.watermelon.moviesapp.ui.categories

import com.watermelon.moviesapp.model.response.genres.Genre
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class CategoriesAdapter(list: List<Genre>, listener: CategoriesInteractionListener) :
    BaseAdapter<Genre>(list, listener) {
    override val layoutID: Int
        get() = R.layout.item_categories
}