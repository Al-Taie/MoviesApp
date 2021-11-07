package com.watermelon.moviesapp.ui.details

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.model.response.credits.Cast
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.search.SearchFragmentDirections
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.DetailsFragmentBinding

class DetailsFragment : BaseFragment<DetailsFragmentBinding>(){
    private val args: DetailsFragmentArgs by navArgs()

    override fun setup() {
        viewModel.onItemClicked(args.movieId)
        binding.viewModel = viewModel
        binding.recyclerCast.adapter = CastAdapter(mutableListOf(),viewModel)
        viewModel.navigateToProfile.observe(this, ::onNavigate)

        viewModel.movieDetails.observe(this, {
            Log.i("idMove", it.toData()?.id.toString())

        })
        viewModel.credits.observe(this, {
            Log.i("cast", it.toData()?.cast.toString())

        })
    }

    override val viewModel: DetailsViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> DetailsFragmentBinding
        get() = DetailsFragmentBinding::inflate

    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let {  personId ->
            val action = DetailsFragmentDirections.actionDetailsFragmentToProfileFragment(personId)
            findNavController().navigate(action)
        }
    }
}