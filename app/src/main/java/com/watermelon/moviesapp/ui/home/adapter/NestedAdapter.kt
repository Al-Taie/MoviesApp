package com.watermelon.moviesapp.ui.home.adapter

import com.watermelon.moviesapp.model.response.movies.Movies
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.BR

class NestedAdapter(
    private var _items: List<List<Movies>>,
    private val _listener: MovieInteractionListener
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = listOf(ViewType.TOP.type, ViewType.MID.type)
    override var layoutID: Int = layoutIDs.first()

    override fun getItemViewType(position: Int): Int {
        layoutID = layoutIDs[position]
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val adapter = when (ViewType.values()[position]) {
            ViewType.TOP -> MovieTopAdapter(_items[position], _listener)
            ViewType.MID -> MovieMiddleAdapter(_items[position], _listener)
        }
        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)
    }

    override fun getItemCount() = layoutIDs.size
}