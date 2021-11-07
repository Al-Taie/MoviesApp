package com.watermelon.moviesapp.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.watermelon.moviesapp.main.RecyclerItem
import com.watermelon.moviesapp.main.RecyclerViewAdapter
import com.watermelon.moviesapp.main.test.NestedAdapter
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.ui.base.BaseAdapter

@BindingAdapter("items")
fun setRecyclerViewItems(
    recyclerView: RecyclerView,
    items: List<RecyclerItem>?
) {
    var adapter = (recyclerView.adapter as? RecyclerViewAdapter)
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
    }

    adapter.updateData(items.orEmpty())
}


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    when (state) {
        is State.Loading -> view.visibility = VISIBLE
        else -> view.visibility = GONE
    }

}


@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    when (state) {
        is State.Error ->
            view.visibility = VISIBLE

        else ->
            view.visibility = GONE

    }
}


@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    when (state) {
        is State.Success ->
            view.visibility = VISIBLE

        else ->
            view.visibility = GONE

    }
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    if (items != null) {
        (view?.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (view?.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}


@BindingAdapter(value = ["app:adapter"])
fun setAdapter(view: RecyclerView?, items: List<Any>) {
    (view?.adapter as NestedAdapter).setItems(items)
}


@BindingAdapter(value = ["app:image"])
fun setImage(view: ShapeableImageView?, imagePath: String?) {
    if (view != null) {
        Glide.with(view)
            .load(Constant.BASE_IMAGE_URL+imagePath)
            .into(view)
    }
}