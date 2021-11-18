package com.watermelon.moviesapp.ui.base
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import watermelon.moviesapp.BR


abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {
    abstract val theme: Int
    abstract val viewID: Int
    abstract val viewModel: ViewModel
    private lateinit var _binding: VDB
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, viewID)
        _binding.setVariable(BR.viewModel, viewModel)
        _binding.lifecycleOwner = this
    }
}