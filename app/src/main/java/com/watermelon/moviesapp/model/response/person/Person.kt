package com.watermelon.moviesapp.model.response.person


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("also_known_as")
    val alsoKnownAs: List<String>?,
    @SerializedName("biography")
    val biography: String?,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("deathday")
    val deathDay: String?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("place_of_birth")
    val placeOfBirth: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val imagePath: String?
)