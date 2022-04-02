package com.example.movies.domain

import com.example.movies.data.repositories.PopularMovieRepository
import com.example.movies.domain.model.Movie
import javax.inject.Inject

class GetPopularMovieDbUseCase @Inject constructor(private val popularMovieRepository: PopularMovieRepository) {

    suspend operator fun invoke(): List<Movie>? {
        val movies = popularMovieRepository.getPopularMoviesFromDB()
        if (!movies.isNullOrEmpty()) {
            return movies
        }
        return null
    }
}