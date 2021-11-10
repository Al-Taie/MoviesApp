package com.watermelon.moviesapp.model.response.providerstv


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("display_priority")
    val displayPriority: Int? = null,
    @SerializedName("logo_path")
    val logoPath: String? = null,
    @SerializedName("provider_id")
    val providerId: Int? = null,
    @SerializedName("provider_name")
    val providerName: String? = null
)