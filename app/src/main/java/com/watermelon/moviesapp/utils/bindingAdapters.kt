package com.watermelon.moviesapp.utils

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.imageview.ShapeableImageView
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.model.response.genres.Genre
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import com.watermelon.moviesapp.model.response.tv.TVResponse
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.home.HomeInteractionListener
import com.watermelon.moviesapp.ui.tv.TvInteractionListener
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
    view?.let {
        Glide.with(view)
            .load(Constant.BASE_IMAGE_URL + imagePath)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .centerCrop()
            .error(R.drawable.ic_baseline_error_outline_24)
            .centerCrop()
            .into(view)
    }
}

@BindingAdapter(value = ["app:theListForChips"])
fun theListForChips(view: ChipGroup, list: List<Genre>?) {
    list?.map {
        Chip(view.context).apply {
            text = it.name
            setPadding(24, 4, 12, 4)
            setTextAppearanceResource(R.style.ChipTextStyle_Selected)
            setChipStrokeColorResource(R.color.base_color)
            setChipStrokeWidthResource(R.dimen.stroke1dp)
            setChipBackgroundColorResource(R.color.background_color)
            view.addView(this)
        }
    }
}

@BindingAdapter(value = ["app:stream", "app:listener"], requireAll = false)
fun streamObserve(view: View, state: State<TVResponse>?, listener: TvInteractionListener?) =
    view.setOnClickListener { listener?.setStream(state) }

@BindingAdapter(value = ["app:showMoreTextLines"])
fun showMoreTextLines(view: TextView, text: String?) {
    var isTextViewClicked = false
    view.setOnClickListener {
        if (isTextViewClicked) {
            view.maxLines = 4
            isTextViewClicked = false
        } else {
            view.maxLines = Integer.MAX_VALUE
            isTextViewClicked = true
        }
    }
}

@BindingAdapter(value = ["app:showAliveOrNot"])
fun showAliveOrNot(view: ImageView, drawable: Drawable?) {
    view.setImageDrawable(drawable)
}

@BindingAdapter(value = ["app:isNotNull"])
fun checkData(view: View, item: Any?) {
    view.isVisible = (item.toString().isNotEmpty() && item != null)
}

@BindingAdapter("app:attachedView")
fun setAttachedView(view: ImageView?, attachedView: LinearLayout?) {
    view?.setOnClickListener {
        attachedView?.let { linearLayout ->
            TransitionManager.beginDelayedTransition(linearLayout, AutoTransition())
            linearLayout.isVisible = (linearLayout.visibility != View.VISIBLE)
            if (linearLayout.isVisible) {
                view.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            } else {
                view.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24)
            }
        }
    }
}

@BindingAdapter(value = ["app:setSlider", "app:listener"], requireAll = false)
fun setSliderItems(view: ImageSlider?, items: List<TrendingMovie>?, listener: HomeInteractionListener?) {
    val itemsList = items?.shuffled()?.take(5)
    itemsList?.run { view?.setImageList(this.map { it.toSlider() }, ScaleTypes.FIT) }

    view?.setItemClickListener(object : ItemClickListener {
        override fun onItemSelected(position: Int) {
            itemsList?.get(position)?.id?.let { listener?.onItemClicked(it) }
        }
    })
}
