package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface CategoriesDisplayInteractionListener:BaseInteractionListener {
    fun onItemClick(id: Int)
}