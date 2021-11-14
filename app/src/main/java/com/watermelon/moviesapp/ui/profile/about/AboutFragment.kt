package com.watermelon.moviesapp.ui.profile.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.profile.ProfileViewModel
import watermelon.moviesapp.databinding.FragmentAboutActorBinding

class AboutFragment : BaseFragment<FragmentAboutActorBinding>() {

    override fun setup() {

    }

    override val viewModel: ProfileViewModel by viewModels ({ requireParentFragment() })
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAboutActorBinding
        get() = FragmentAboutActorBinding::inflate
}