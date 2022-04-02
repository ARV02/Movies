package com.example.movies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movies.data.database.dao.MoviesDao
import com.example.movies.data.database.dao.NowPlayingDao
import com.example.movies.data.database.entities.MoviesEntity
import com.example.movies.data.database.entities.NowPlayingEntity

@Database(entities = [MoviesEntity::class,
                     NowPlayingEntity::class], version = 1, exportSchema = false)
abstract class MoviesDataBase: RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao

    abstract fun getNowPlayingDao(): NowPlayingDao
}