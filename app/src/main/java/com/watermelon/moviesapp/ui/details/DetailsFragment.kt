package com.watermelon.moviesapp.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val viewModel: DetailsViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    private val args: DetailsFragmentArgs by navArgs()

    override fun setup() {
        viewModel.onItemLoad(args.movieId)
        initRecyclers()
        viewModel.navigateToProfile.observe(this, ::onNavigate)
        addBottomSheet()
    }

    private fun initRecyclers() {
        binding.recyclerCast.adapter = CastAdapter(mutableListOf(), viewModel)
        binding.recyclerSimilar.adapter = SimilarMoviesAdapter(mutableListOf(), viewModel)
    }

    private fun addBottomSheet() {
        BottomSheetBehavior.from(binding.detailsMovie).apply {
            peekHeight = 450
            state = STATE_COLLAPSED

            addBottomSheetCallback(object :  BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {}

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    if (slideOffset == 0f) { binding.detailsMovie.smoothScrollTo(0, 0) }
                }
            })
        }
    }

    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let { personId ->
            val action = DetailsFragmentDirections.actionDetailsFragmentToProfileFragment(personId)
            findNavController().navigate(action)
        }
    }

}