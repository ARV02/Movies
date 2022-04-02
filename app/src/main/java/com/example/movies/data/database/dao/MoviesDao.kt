package com.example.movies.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.data.database.entities.MoviesEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_table")
    suspend fun getAppMovies(): List<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MoviesEntity>)

    @Query("DELETE FROM movies_table")
    suspend fun deleteAllPlatforms()
}