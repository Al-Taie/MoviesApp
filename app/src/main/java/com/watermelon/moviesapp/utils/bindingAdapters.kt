package com.watermelon.moviesapp.utils

import android.annotation.SuppressLint
import android.view.View
import androidx.core.view.isVisible
import androidx.core.view.marginLeft
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.imageview.ShapeableImageView
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.response.genres.Genre
import com.watermelon.moviesapp.ui.base.BaseAdapter
import watermelon.moviesapp.R


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    view.isVisible = (state is State.Loading)
}


@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    view.isVisible = (state is State.Error)
}


@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    view.isVisible = (state is State.Success)
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:image"])
fun setImage(view: ShapeableImageView?, imagePath: String?) {
    if (view != null) {
        Glide.with(view)
            .load(Constant.BASE_IMAGE_URL + imagePath)
            .into(view)
    }
}


@SuppressLint("ResourceAsColor", "ResourceType")
@BindingAdapter(value = ["app:theListForChips"])
fun theListForChips(view: ChipGroup , list: List<Genre>?) {
    list?.map {
        Chip(view.context).apply {
           text = it.name
            setPadding(24 , 4, 12,4)
            setChipStrokeColorResource(R.color.base_color)
            setChipStrokeWidthResource(R.dimen.stroke1dp)
            setChipBackgroundColorResource(R.color.backgruond_color)
            view.addView(this)
        }
    }
}





