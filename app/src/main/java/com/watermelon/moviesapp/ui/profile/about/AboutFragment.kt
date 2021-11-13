package com.watermelon.moviesapp.ui.profile.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentAboutActorBinding

class AboutFragment : BaseFragment<FragmentAboutActorBinding>() {
    override fun setup() {
        TODO("Not yet implemented")
    }

    override val viewModel: AboutViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAboutActorBinding
        get() = FragmentAboutActorBinding::inflate
}