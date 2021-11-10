package com.watermelon.moviesapp.ui.trending.adapter

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.watermelon.moviesapp.model.response.trending.all.TrendingAll
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import com.watermelon.moviesapp.model.response.trending.person.TrendingPerson
import com.watermelon.moviesapp.model.response.trending.tv.TrendingTV
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.trending.TrendingInteractionListener
import com.watermelon.moviesapp.utils.AdapterDiffUtil
import watermelon.moviesapp.BR

class TrendingNestedAdapter(
    private var _items: MutableList<List<Any>>,
    private val _listener: TrendingInteractionListener
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = ViewType.values().map { it.id }
    override var layoutID: Int = layoutIDs.first()

    override fun getItemViewType(position: Int): Int {
        layoutID = layoutIDs[position]
        return super.getItemViewType(position)
    }

    fun setItemsAt(newItems: List<Any>, index: Int) {
        _items[index] = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
            val adapter = when(ViewType.values()[position]) {
                ViewType.PERSON -> TrendingPersonAdapter(
                    _items[position] as List<TrendingPerson>,
                    _listener
                )
                ViewType.MOVIE -> TrendingMovieAdapter(
                    _items[position] as List<TrendingMovie>,
                    _listener
                )
                ViewType.TV -> TrendingTVAdapter(_items[position] as List<TrendingTV>, _listener)
                ViewType.ALL -> TrendingAllAdapter(_items[position] as List<TrendingAll>, _listener)
            }
            (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)
    }

    override fun getItemCount() = layoutIDs.size
}