package com.watermelon.moviesapp.ui.tv.adapter

import com.watermelon.moviesapp.model.response.channel.ChannelResponse
import com.watermelon.moviesapp.model.response.tv.Season
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.tv.TvInteractionListener
import watermelon.moviesapp.BR

class TvNestedAdapter(
    private var _items: List<List<Any>>,
    private val _listener: TvInteractionListener
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = TvViewType.values().map { it.id }
    override var layoutID: Int = layoutIDs.first()

    override fun getItemViewType(position: Int): Int {
        layoutID = layoutIDs[position]
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val adapter = when (TvViewType.values()[position]) {
            TvViewType.TV_SEASON -> TvSeasonAdapter(
                _items[position] as List<Season>,
                _listener
            )
            TvViewType.TV_CHANNEL -> TvChannelAdapter(
                _items[position] as List<ChannelResponse>,
                _listener
            )
            TvViewType.TV_CHANNEL_PROVIDERS -> TODO()
        }
        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)
    }

    override fun getItemCount() = layoutIDs.size
}