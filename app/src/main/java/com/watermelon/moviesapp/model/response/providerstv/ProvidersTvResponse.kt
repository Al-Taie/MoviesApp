package com.watermelon.moviesapp.model.response.providerstv


import com.google.gson.annotations.SerializedName

data class ProvidersTvResponse(
    @SerializedName("results")
    val results: List<Result>? = null
)