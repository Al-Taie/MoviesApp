package com.watermelon.moviesapp.ui.base
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel


abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {
    abstract fun setup()
    abstract val theme: Int
    abstract val viewID: Int
    abstract val viewModelID: Int
    abstract val viewModel: ViewModel
    private lateinit var _binding: VDB
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, viewID)
        _binding.setVariable(viewModelID, viewModel)
        _binding.lifecycleOwner = this
        setup()
    }
}