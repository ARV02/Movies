package com.example.movies.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movies.domain.model.Movie

@Entity(tableName = "movies_table")
data class MoviesEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "movie_id") val movieId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name ="poster_path") val poster: String,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "overview") val overview: String
)

fun Movie.toDatabase() = MoviesEntity(movieId = movieId, title = title, poster = poster, release_date = release_date, overview = overview)