package com.example.movies.data.database

import com.example.movies.data.database.dao.NowPlayingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun providesNowPlayingDao(moviesDataBase: MoviesDataBase): NowPlayingDao {
        return moviesDataBase.getNowPlayingDao()
    }
}