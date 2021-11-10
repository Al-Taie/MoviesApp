package com.watermelon.moviesapp.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
    private val args: DetailsFragmentArgs by navArgs()

    override fun setup() {
        viewModel.onItemLoad(args.movieId)
        binding.recyclerCast.adapter = CastAdapter(mutableListOf(), viewModel)

        viewModel.navigateToProfile.observe(this, ::onNavigate)

        viewModel.credits.observe(this, { state ->
            try {
                binding.directorName.text =
                    state.toData()?.crew?.first { it.job == "Director" }?.name
                binding.writersName.text =
                    state.toData()?.crew?.first { it.department == "Writing" }?.name
            } catch (e: NoSuchElementException) {

            }
        })
    }

    override val viewModel: DetailsViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let { personId ->
            val action = DetailsFragmentDirections.actionDetailsFragmentToProfileFragment(personId)
            findNavController().navigate(action)
        }
    }
}