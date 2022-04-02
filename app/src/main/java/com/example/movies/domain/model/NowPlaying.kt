package com.example.movies.domain.model

import com.example.movies.data.database.entities.NowPlayingEntity
import com.example.movies.data.models.NowPlayingModel

data class NowPlaying (
    val movieId: Int,
    val title: String,
    val poster: String,
    val release_date: String,
    val overview: String
)
fun NowPlayingModel.toDomain() = NowPlaying(movieId, title, poster, release_date, overview)
fun NowPlayingEntity.toDomain() = NowPlaying(movieId, title, poster, release_date, overview)