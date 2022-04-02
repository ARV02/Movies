package com.example.movies.domain

import com.example.movies.data.database.entities.toDatabase
import com.example.movies.data.repositories.PopularMovieRepository
import com.example.movies.domain.model.Movie
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(private val popularMovieRepository: PopularMovieRepository) {

    suspend operator fun invoke(page: Int): List<Movie> {
        val movies = popularMovieRepository.getPopularMovieFromApi(page)
        return if(movies.isNotEmpty()) {
            popularMovieRepository.clearMovies()
            popularMovieRepository.insertPopularMovies(movies.map { it.toDatabase() })
            movies
        } else {
            popularMovieRepository.getPopularMoviesFromDB()
        }
    }
}