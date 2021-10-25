package com.watermelon.moviesapp.ui

import androidx.activity.viewModels
import com.watermelon.moviesapp.ui.base.BaseActivity
import com.watermelon.moviesapp.viewModels.MainViewModel
import watermelon.moviesapp.BR
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_MoviesApp
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
    override val viewModelID = BR.viewModel

    override fun setup() {}

}