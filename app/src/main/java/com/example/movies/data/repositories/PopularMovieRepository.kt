package com.example.movies.data.repositories

import com.example.movies.data.database.dao.MoviesDao
import com.example.movies.data.database.entities.MoviesEntity
import com.example.movies.data.network.PopularMovieService
import com.example.movies.domain.model.Movie
import com.example.movies.domain.model.toDomain
import javax.inject.Inject

class PopularMovieRepository @Inject constructor(private val popularMovieService: PopularMovieService, private val moviesDao: MoviesDao) {

    suspend fun getPopularMovieFromApi(page: Int): List<Movie> {
        val response = popularMovieService.movieMostPopular(page)
        return response.movieList.map { it.toDomain() }
    }

    suspend fun getPopularMoviesFromDB(): List<Movie> {
        val response =  moviesDao.getAppMovies()
        return response.map { it.toDomain() }
    }

    suspend fun insertPopularMovies(movies: List<MoviesEntity>) {
        moviesDao.insertAll(movies)
    }

    suspend fun clearMovies() {
        moviesDao.deleteAllPlatforms()
    }
}