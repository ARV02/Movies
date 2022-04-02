package com.example.movies.data.models

import com.google.gson.annotations.SerializedName

data class VideosModel(
    @SerializedName("iso_639_1")
    val iso_639_1: String = "en",
    @SerializedName("iso_3166_1")
    val iso_3166_1: String = "US",
    @SerializedName("name")
    val name: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: Int
)

data class VideosResult(
    @SerializedName("results")
    val videosList: List<VideosModel>
)
