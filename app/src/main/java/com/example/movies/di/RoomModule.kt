package com.example.movies.di

import android.content.Context
import androidx.room.Room
import com.example.movies.data.database.MoviesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val MOVIES_DATABASE_NAME = "movies_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MoviesDataBase::class.java, MOVIES_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideMoviesDao(db: MoviesDataBase) = db.getMoviesDao()
}