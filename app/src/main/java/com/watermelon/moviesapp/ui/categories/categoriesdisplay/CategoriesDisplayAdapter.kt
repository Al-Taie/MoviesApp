package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class CategoriesDisplayAdapter(list: List<Movie>, listener: CategoriesDisplayInteractionListener) :
    BaseAdapter<Movie>(list, listener) {
    override val layoutID: Int
        get() = R.layout.item_categories_display
}