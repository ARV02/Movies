package com.example.movies.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.data.database.entities.NowPlayingEntity

@Dao
interface NowPlayingDao {
    @Query("SELECT * FROM nowPlaying_table")
    suspend fun getAllMovies(): List<NowPlayingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<NowPlayingEntity>)

    @Query("DELETE FROM nowPlaying_table")
    suspend fun deleteAllMovies()
}