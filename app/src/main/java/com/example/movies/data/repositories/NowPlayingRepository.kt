package com.example.movies.data.repositories

import com.example.movies.data.database.dao.NowPlayingDao
import com.example.movies.data.database.entities.MoviesEntity
import com.example.movies.data.database.entities.NowPlayingEntity
import com.example.movies.data.models.MoviesPageModel
import com.example.movies.data.network.NowPlayingService
import com.example.movies.domain.model.NowPlaying
import com.example.movies.domain.model.toDomain
import javax.inject.Inject

class NowPlayingRepository @Inject constructor(private val nowPlayingService: NowPlayingService, private val nowPlayingDao: NowPlayingDao) {

    suspend fun nowPlayingMovieFromApi(page: Int): List<NowPlaying> {
        val response = nowPlayingService.nowPlaying(page)
        return response.movieList.map { it.toDomain() }
    }

    suspend fun nowPlayingMovieFromDB():List<NowPlaying> {
        val response = nowPlayingDao.getAllMovies()
        return response.map { it.toDomain() }
    }

    suspend fun insertNowPlayingMovie(movies: List<NowPlayingEntity>) {
        nowPlayingDao.insertAll(movies)
    }

    suspend fun deleteNowPlayingMovie() {
        nowPlayingDao.deleteAllMovies()
    }
}