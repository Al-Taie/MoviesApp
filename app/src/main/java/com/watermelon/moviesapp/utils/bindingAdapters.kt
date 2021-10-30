package com.watermelon.moviesapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.watermelon.moviesapp.ui.base.BaseAdapter


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items!=null){

        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    }else
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())

}

@BindingAdapter(value = ["app:image"])
fun setImage(view: ShapeableImageView, imagePath: String) {
    Glide.with(view.context)
        .load(imagePath)
        .into(view)
}