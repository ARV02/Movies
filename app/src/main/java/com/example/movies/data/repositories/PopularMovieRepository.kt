package com.example.movies.data.repositories

import com.example.movies.data.models.MovieModel
import com.example.movies.data.models.MoviesPageModel
import com.example.movies.data.network.PopularMovieService
import com.example.movies.domain.model.Movie
import com.example.movies.domain.model.toDomain
import javax.inject.Inject

class PopularMovieRepository @Inject constructor(private val popularMovieService: PopularMovieService) {

    suspend fun popularMovie(page: Int): MoviesPageModel = popularMovieService.movieMostPopular(page)
}