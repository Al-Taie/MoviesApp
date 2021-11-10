package com.watermelon.moviesapp.ui.tv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.response.channel.ChannelResponse
import com.watermelon.moviesapp.model.response.tv.TvResponse
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.tv.adapter.TvNestedAdapter
import watermelon.moviesapp.databinding.FragmentTvBinding

class TvFragment : BaseFragment<FragmentTvBinding>() {

    override fun setup() {


        viewModel.latestTvShow.observe(this, { state ->
            when (state) {
                is State.Success -> state.data?.seasons?.let { data ->
                    Log.v("TESTING", data.toString())

                    val items = listOf(
                        data,
                        emptyList<TvResponse>()
                    )

                    binding.adapter = TvNestedAdapter(items, viewModel)
                }
                is State.Error -> Log.v("TESTING", state.message)
            }
        })

//        viewModel.tvShowChannel.observe(this, { state ->
//            when (state) {
//                is State.Success -> state.data?.results?.let { data ->
//                    Log.v("TESTINGTV", data.toString())
//
//                    val items = listOf(
//                        data,
//                        emptyList<ChannelResponse>()
//                    )
//
//                    binding.adapter = TvNestedAdapter(items, viewModel)
//                }
//                is State.Error -> Log.v("TESTING", state.message)
//            }
//        })
    }

    override val viewModel: TvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvBinding
        get() = FragmentTvBinding::inflate
}