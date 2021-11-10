package com.watermelon.moviesapp.model.response.channel


import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName("display_priority")
    val displayPriority: Int? = null,
    @SerializedName("logo_path")
    val logoPath: String? = null,
    @SerializedName("provider_id")
    val providerId: Int? = null,
    @SerializedName("provider_name")
    val providerName: String? = null
)