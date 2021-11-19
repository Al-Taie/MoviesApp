package com.watermelon.moviesapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val viewModel: DetailsViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclers()
        addBottomSheet()
        observe()
        binding.goBack.setOnClickListener { findNavController().navigateUp() }
    }

    private fun initRecyclers() {
        binding.recyclerCast.adapter = CastAdapter(mutableListOf(), viewModel)
        binding.recyclerSimilar.adapter = SimilarMoviesAdapter(mutableListOf(), viewModel)
    }

    private fun addBottomSheet() {
        BottomSheetBehavior.from(binding.detailsMovie).apply {
            peekHeight = 450
            state = STATE_COLLAPSED
        }
    }


    private fun onNavigate(personId: Int) {
        val action = DetailsFragmentDirections.actionDetailsFragmentToProfileFragment(personId)
        findNavController().navigate(action)
    }

    private fun onNavigateToItSelf(movieId: Int) {
        val action = DetailsFragmentDirections.actionDetailsFragmentToDetailsFragment(movieId)
        findNavController().navigate(action)
    }

    private fun observe() {
        viewModel.apply {
            onItemLoad(args.movieId)
            navigateToProfile.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
            navigateToItSelf.observe(viewLifecycleOwner, EventObserver { onNavigateToItSelf(it) })
        }
    }
}