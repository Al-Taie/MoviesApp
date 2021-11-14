package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import com.watermelon.moviesapp.model.response.genres.Genre
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.categories.CategoriesInteractionListener
import watermelon.moviesapp.R

class CategoriesDisplayAdapter(list: List<Movie>, listener: CategoriesInteractionListener) :
    BaseAdapter<Movie>(list, listener) {
    override val layoutID: Int
        get() = R.layout.item_categories_display
}