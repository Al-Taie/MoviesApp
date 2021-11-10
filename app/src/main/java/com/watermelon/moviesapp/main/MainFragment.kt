package com.watermelon.moviesapp.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.watermelon.moviesapp.ui.home.adapter.NestedAdapter
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun setup() {
        viewModel.movies.observe(this, { state ->
            if (state is State.Success) {
                state.data?.items?.let {
                    val items = listOf(it, it)
                    binding.adapter = NestedAdapter(items, viewModel)
                }
            }

            when(state) {
                is State.Error -> Log.v("TESTING", state.message)
            }
        })
    }

    override val viewModel: MainViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate
}