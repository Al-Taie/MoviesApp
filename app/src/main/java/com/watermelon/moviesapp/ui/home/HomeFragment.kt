package com.watermelon.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.home.adapter.NestedAdapter
import com.watermelon.moviesapp.ui.home.adapter.ViewType
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun setup() {
        val adapter = NestedAdapter(mutableListOf(), viewModel)

        viewModel.movies.observe(this, { state ->
            if (state is State.Success) {
                state.data?.items?.let { data ->
                    adapter.setItemsAt(data, ViewType.TOP.index)
                    adapter.setItemsAt(data, ViewType.MID.index)
                }
                binding.adapter = adapter
            }
        })

        viewModel.genres.observe(this, { genres ->
            var chip_item: Chip
            val inflater = layoutInflater
            if (genres.toData()?.genres != null) {
                for (item in genres.toData()?.genres!!.indices) {
                    chip_item = inflater.inflate(R.layout.chip_item, null, false) as Chip
                    chip_item.text = genres.toData()?.genres?.get(item)?.name.toString()
                    chip_item.setOnClickListener {
                        val action = genres.toData()?.genres?.get(item)?.id?.let { it1 ->
                            HomeFragmentDirections.actionHomeFragmentToGenreFragment(genreId = it1)
                        }
                        if (action != null) {
                            findNavController().navigate(action)
                        }
                    }
                    binding.chipGroup.addView(chip_item)
                }
            }
        })
    }

    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}