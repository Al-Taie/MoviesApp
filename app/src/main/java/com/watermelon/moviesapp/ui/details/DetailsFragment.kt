package com.watermelon.moviesapp.ui.details

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.DetailsFragmentBinding

class DetailsFragment : BaseFragment<DetailsFragmentBinding>(){
    private val args: DetailsFragmentArgs by navArgs()

    override fun setup() {
        viewModel.onItemLoad(args.movieId)
        binding.recyclerCast.adapter = CastAdapter(mutableListOf(),viewModel)

        viewModel.navigateToProfile.observe(this, ::onNavigate)
        viewModel.credits.observe(this,{
          binding.directorName.text = it.toData()?.crew?.filter { it.job == "Director" }.toString()
        })
//        viewModel.credits.observe(this,{
//            binding.writersName.text = it.toData()?.crew?.filter { it.department == "Writing" }.toString()
//        })
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