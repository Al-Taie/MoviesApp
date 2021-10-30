package com.watermelon.moviesapp.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import watermelon.moviesapp.BR

interface BaseInteractionListener

abstract class BaseAdapter<T>(
    private var _items: List<T>,
    private val _listener: BaseInteractionListener
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    override fun getItemCount() = _items.size
    fun setItems(newItems: List<T>) {

        _items = newItems
        notifyDataSetChanged()
    }
    val items get() = _items

    abstract val layoutID: Int

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(DataBindingUtil.inflate(inflater, layoutID, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = _items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.apply {
                    setVariable(BR.item, currentItem)
                    setVariable(BR.listener, _listener)
                }
            }
        }
    }
}



