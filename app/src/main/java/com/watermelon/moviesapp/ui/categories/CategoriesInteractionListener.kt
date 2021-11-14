package com.watermelon.moviesapp.ui.categories

import com.watermelon.moviesapp.ui.base.BaseInteractionListener

interface CategoriesInteractionListener:BaseInteractionListener {
    fun onItemClick(id: Int)
}