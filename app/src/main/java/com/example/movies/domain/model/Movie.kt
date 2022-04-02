package com.example.movies.domain.model

import com.example.movies.data.database.entities.MoviesEntity
import com.example.movies.data.models.MovieModel
import com.example.movies.data.models.MoviesPageModel
import com.google.gson.annotations.SerializedName

data class Movie (
    val movieId: Int,
    val title: String,
    val poster: String,
    val release_date: String,
    val overview: String
)

fun MovieModel.toDomain() = Movie(movieId, title, poster, release_date, overview)
fun MoviesEntity.toDomain() = Movie(movieId, title, poster, release_date, overview)