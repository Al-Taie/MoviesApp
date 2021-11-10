package com.watermelon.moviesapp.ui.tv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.response.channel.Channel
import com.watermelon.moviesapp.model.response.channel.ChannelResponse
import com.watermelon.moviesapp.model.response.trending.all.TrendingAll
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import com.watermelon.moviesapp.model.response.trending.person.TrendingPerson
import com.watermelon.moviesapp.model.response.trending.tv.TrendingTV
import com.watermelon.moviesapp.model.response.tv.Season
import com.watermelon.moviesapp.model.response.tv.TvResponse
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.trending.adapter.TrendingNestedAdapter
import com.watermelon.moviesapp.ui.tv.adapter.TvNestedAdapter
import com.watermelon.moviesapp.ui.tv.adapter.TvViewType
import watermelon.moviesapp.databinding.FragmentTvBinding

class TvFragment : BaseFragment<FragmentTvBinding>() {

    override fun setup() {
        val items = mutableListOf(
            emptyList<Season>(),
            emptyList<Channel>()
        )
        val adapter = TvNestedAdapter(items, viewModel)
        viewModel.latestTvShow.observe(this, { state ->
            if (state is State.Success) {
                state.data?.seasons?.let { data ->
                    Log.v("TESTING", data.toString())
                    adapter.setItemsAt(data, TvViewType.TV_SEASON.index)
                    binding.adapter = adapter
                }
            }
        })

        viewModel.tvShowChannel.observe(this, { state ->
            if (state is State.Success) {
                state.data?.results?.let { data ->
                    Log.v("TESTING", data.toString())
                    adapter.setItemsAt(data, TvViewType.TV_CHANNEL.index)
                    binding.adapter = adapter
                }
            }
        })
    }

    override val viewModel: TvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvBinding
        get() = FragmentTvBinding::inflate
}