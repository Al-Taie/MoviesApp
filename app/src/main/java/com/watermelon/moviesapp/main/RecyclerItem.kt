package com.watermelon.moviesapp.main

import androidx.annotation.LayoutRes
import androidx.databinding.BaseObservable
import androidx.databinding.ViewDataBinding

class RecyclerItem(
    val data: Any,
    @LayoutRes val layoutId: Int,
    val variableId: Int
) : BaseObservable() {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId, data)
    }
}
