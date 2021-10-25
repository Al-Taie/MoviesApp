package com.watermelon.moviesapp.ui

import androidx.activity.viewModels
import com.watermelon.footballapp.ui.base.BaseActivity
import com.watermelon.moviesapp.viewModels.HomeViewModel
import watermelon.moviesapp.R
import watermelon.moviesapp.BR
import watermelon.moviesapp.databinding.ActivityHomeBinding


class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val theme = R.style.Theme_MoviesApp
    override val viewID = R.layout.activity_home
    override val viewModel: HomeViewModel by viewModels()
    override val viewModelID = BR.viewModel

    override fun setup() {}

}