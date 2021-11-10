package com.watermelon.moviesapp.ui.home.adapter

import com.watermelon.moviesapp.model.response.movies.Movies
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.BR
import watermelon.moviesapp.databinding.ItemMoviesTopListBinding

class NestedAdapter(
    private var _items: MutableList<List<Movies>>,
    private val _listener: MovieInteractionListener
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = listOf(ViewType.TOP.type, ViewType.MID.type)
    override var layoutID: Int = layoutIDs.first()

    override fun getItemViewType(position: Int): Int {
        layoutID = layoutIDs[position]
        return super.getItemViewType(position)
    }

    fun setItemsAt(newItems: List<Movies>, index: Int) {
        _items[index] = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val adapter = when (ViewType.values()[position]) {
            ViewType.TOP -> MovieTopAdapter(_items[position], _listener)
            ViewType.MID -> MovieMiddleAdapter(_items[position], _listener)
        }
        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)

        if (position == 1) return

        (holder.binding as ItemMoviesTopListBinding).recyclerMovies.adapter = adapter
    }

    override fun getItemCount() = _items.size
}