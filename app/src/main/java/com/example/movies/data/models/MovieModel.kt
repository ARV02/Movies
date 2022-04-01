package com.example.movies.data.models

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("overview")
    val overview: String
    )

