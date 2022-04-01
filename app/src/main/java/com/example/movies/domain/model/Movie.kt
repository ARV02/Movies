package com.example.movies.domain.model

import com.example.movies.data.models.MovieModel
import com.google.gson.annotations.SerializedName

data class Movie (
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
fun MovieModel.toDomain() = Movie(movieId, title, poster, release_date, overview)