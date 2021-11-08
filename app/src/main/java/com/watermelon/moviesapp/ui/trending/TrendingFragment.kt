package com.watermelon.moviesapp.ui.trending

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.response.trending.all.TrendingAll
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import com.watermelon.moviesapp.model.response.trending.tv.TrendingTV
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.trending.adapter.TrendingNestedAdapter
import watermelon.moviesapp.databinding.FragmentTrendingBinding

class TrendingFragment : BaseFragment<FragmentTrendingBinding>() {
    companion object {
        fun newInstance() = TrendingFragment()
    }

    override fun setup() {

        viewModel.trendingPerson.observe(this, { state ->
            when (state) {
                is State.Success -> state.data?.results?.let { data ->
                    Log.v("TESTING", data.toString())

                    val items = listOf(data,
                        emptyList<TrendingMovie>(),
                        emptyList<TrendingTV>(),
                        emptyList<TrendingAll>())

                    binding.adapter = TrendingNestedAdapter(items, viewModel)
                }
                is State.Error -> Log.v("TESTING", state.message)
            }
        })

    }

    override val viewModel: TrendingViewModel by activityViewModels()

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTrendingBinding
        get() = FragmentTrendingBinding::inflate
}