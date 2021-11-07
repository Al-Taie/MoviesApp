package com.watermelon.moviesapp.ui.home.adapter

import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeViewModel
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.BR
import watermelon.moviesapp.R

class MovieTopAdapter(list: List<Movie>, listener: MovieInteractionListener, val viewModel: HomeViewModel) :
        BaseAdapter<Movie>(list, listener) {
        override var layoutID = R.layout.item_home_top_recycler

        override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
                super.onBindViewHolder(holder, position)
                (holder as ItemViewHolder).binding.setVariable(BR.viewModel, viewModel)
        }
}