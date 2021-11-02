package com.watermelon.moviesapp.utils

import androidx.recyclerview.widget.DiffUtil

class  MatchDiffUtil<T>(val mOldList: List<T>, val mNewList: List<T>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = mOldList.size

    override fun getNewListSize() = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                mOldList[oldItemPosition]==mNewList[newItemPosition]
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return true
    }
}