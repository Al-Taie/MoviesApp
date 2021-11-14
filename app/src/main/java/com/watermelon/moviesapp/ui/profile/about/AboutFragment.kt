package com.watermelon.moviesapp.ui.profile.about

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.profile.ProfileViewModel
import com.watermelon.moviesapp.utils.Constant
import watermelon.moviesapp.databinding.FragmentAboutActorBinding

class AboutFragment : BaseFragment<FragmentAboutActorBinding>() {

    override fun setup() {
        arguments?.getInt(Constant.ID)?.run { viewModel.onItemLoad(this) }

        Log.i("TESTING", "test")

    }

    override val viewModel: AboutViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAboutActorBinding
        get() = FragmentAboutActorBinding::inflate
}