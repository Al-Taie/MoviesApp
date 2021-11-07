package com.watermelon.moviesapp.main.test

import androidx.lifecycle.ViewModel
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeViewModel
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import com.watermelon.moviesapp.ui.home.adapter.MovieMiddleAdapter
import com.watermelon.moviesapp.ui.home.adapter.MovieTopAdapter
import watermelon.moviesapp.BR

class NestedAdapter(
    private val viewModel: ViewModel,
    private var _items: List<List<Movie>>,
    private val _listener: MovieInteractionListener
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = mutableListOf(ViewType.TOP.type, ViewType.MID.type)
    override var layoutID: Int = layoutIDs[0]

    override fun getItemViewType(position: Int): Int {
        layoutID = layoutIDs[position]
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val adapter = when(ViewType.values()[position]) {
            ViewType.TOP -> MovieTopAdapter(_items[position], _listener)
            ViewType.MID -> MovieMiddleAdapter(_items[position], _listener)
        }

        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)
    }
}