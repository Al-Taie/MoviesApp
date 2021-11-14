package com.watermelon.moviesapp.ui.tv

import com.watermelon.moviesapp.model.response.tv.TV
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R

class TVAdapter(
    _items: List<TV>,
    _listener: TvInteractionListener
) : BaseAdapter<TV>(_items, _listener) {
    override val layoutID: Int = R.layout.item_tv
}
