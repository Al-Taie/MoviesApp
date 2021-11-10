package com.watermelon.moviesapp.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.watermelon.moviesapp.model.response.movies.Movies
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.BR
import watermelon.moviesapp.databinding.ItemMoviesMidlleListBinding
import watermelon.moviesapp.databinding.ItemMoviesTopListBinding

class NestedAdapter(
    private var _items: List<List<Movies>>,
    private val _listener: MovieInteractionListener
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = listOf(ViewType.TOP.type, ViewType.MID.type)
    override var layoutID: Int = layoutIDs.first()

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun getItemViewType(position: Int): Int {
        layoutID = layoutIDs[position]
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val viewType = ViewType.values()[position]
        val adapter = when (viewType) {
            ViewType.TOP -> MovieTopAdapter(_items[position], _listener)
            ViewType.MID -> MovieMiddleAdapter(_items[position], _listener)
        }
        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)

//        if (viewType != ViewType.TOP) { return }
//
//        (holder.binding as ItemMoviesTopListBinding).recyclerMovies.apply {
//            this.adapter = adapter
//            layoutManager =
//                CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL).apply {
//                    setPostLayoutListener(CarouselZoomPostLayoutListener())
//                }
//            setHasFixedSize(true)
//            setRecycledViewPool(viewPool)
//        }
    }

    override fun getItemCount() = layoutIDs.size
}