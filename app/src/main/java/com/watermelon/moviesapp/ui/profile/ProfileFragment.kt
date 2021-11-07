package com.watermelon.moviesapp.ui.profile

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.details.DetailsFragmentArgs
import watermelon.moviesapp.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private val args: ProfileFragmentArgs by navArgs()


    override val viewModel: ProfileViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    override fun setup() {
        viewModel.onItemClicked(args.personId)

        binding.viewModel = viewModel
        viewModel.person.observe(this, {
            Log.i("person", it.toData()?.name.toString())

        })

    }

}

