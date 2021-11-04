package com.watermelon.moviesapp.main


class TestListItem(val test1:String, val tset2:String) {
    var    onDeleteCallback : ((TestListItem)->Unit)? = null
    fun onDeleteClicked(){
        onDeleteCallback?.invoke(this)
    }
}