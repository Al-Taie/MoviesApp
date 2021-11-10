package com.watermelon.moviesapp.ui.trending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.response.trending.all.TrendingAll
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import com.watermelon.moviesapp.model.response.trending.person.TrendingPerson
import com.watermelon.moviesapp.model.response.trending.tv.TrendingTV
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.trending.adapter.TrendingNestedAdapter
import com.watermelon.moviesapp.ui.trending.adapter.ViewType
import watermelon.moviesapp.databinding.FragmentTrendingBinding

class TrendingFragment : BaseFragment<FragmentTrendingBinding>() {
    override fun setup() {
        val items = mutableListOf(
            emptyList<TrendingAll>(),
            emptyList<TrendingPerson>(),
            emptyList<TrendingMovie>(),
            emptyList<TrendingTV>()
            )
        val adapter = TrendingNestedAdapter(items, viewModel)

        viewModel.trendingAll.observe(this, { state ->
            if (state is State.Success) {
                state.data?.results?.let { data ->
                    adapter.setItemsAt(data, ViewType.ALL.index)
                }
            }

        })

        viewModel.trendingPerson.observe(this, { state ->
            if (state is State.Success) {
                state.data?.results?.let { data ->
                    adapter.setItemsAt(data, ViewType.PERSON.index)
                }
            }
        })

        viewModel.trendingMovies.observe(this, { state ->
            if (state is State.Success) {
                state.data?.results?.let { data ->
                    adapter.setItemsAt(data, ViewType.MOVIE.index)
                }
            }
        })

        viewModel.trendingTV.observe(this, { state ->
            if (state is State.Success) {
                state.data?.results?.let { data ->
                    adapter.setItemsAt(data, ViewType.TV.index)
                }
            }
        })

        binding.adapter = adapter
    }

    override val viewModel: TrendingViewModel by activityViewModels()

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTrendingBinding
        get() = FragmentTrendingBinding::inflate

    private fun <T> onResponse(state: State<T>) {
//        when (state) {
//            is State.Success -> state.data?.results?.let { data ->
//                Log.v("TESTING", data.toString())
//                binding.adapter.setItems(data)
//            }
//            is State.Error -> Log.v("TESTING", state.message)
//        }
    }
}