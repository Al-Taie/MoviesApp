package com.watermelon.moviesapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.chip.Chip
import com.watermelon.moviesapp.model.response.genres.Genre
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.home.adapter.MovieTopListAdapter
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun setup() {
        binding.homeFragmentRecycler.adapter = MovieTopListAdapter(emptyList(), viewModel)

        viewModel.genres.observe(this,{
            var chip_item : Chip
            val inflater = layoutInflater
            if (it.toData()?.genres != null) {
                for (item in 0 until it.toData()?.genres!!.size){
                    chip_item = inflater.inflate(R.layout.chip_item,null,false) as Chip
                    chip_item.text = it.toData()?.genres?.get(item)?.name.toString()
                    binding.chipGroup.addView(chip_item)
                }
            }
        })
    }

    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}