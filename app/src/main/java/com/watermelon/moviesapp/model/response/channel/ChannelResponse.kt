package com.watermelon.moviesapp.model.response.channel


import com.google.gson.annotations.SerializedName

data class ChannelResponse(
    @SerializedName("results")
    val results: List<Channel>? = null
)