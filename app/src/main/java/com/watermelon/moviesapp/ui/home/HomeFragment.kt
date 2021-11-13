package com.watermelon.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun setup() {
        binding.homeFragmentRecycler.apply {
//            adapter = MovieTopAdapter(emptyList(), viewModel)
            layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL).apply {
                    setPostLayoutListener(CarouselZoomPostLayoutListener())
                setHasFixedSize(true)
            }

            binding.searchBar.setOnFocusChangeListener { _, isFocused ->
                if (isFocused) {
                    val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                    val extras = FragmentNavigatorExtras(
                        binding.searchBar to getString(R.string.search_transition)
                    )
                    findNavController().navigate(action,extras)
                }
            }
        }

        viewModel.genres.observe(this, { genres ->
            var chip_item: Chip
            val inflater = layoutInflater
            if (genres.toData()?.genres != null) {
                for (item in genres.toData()?.genres!!.indices) {
                    chip_item = inflater.inflate(R.layout.chip_item, null, false) as Chip
                    chip_item.text = genres.toData()?.genres?.get(item)?.name.toString()
                    chip_item.setOnClickListener {

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