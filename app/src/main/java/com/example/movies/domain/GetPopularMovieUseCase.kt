package com.example.movies.domain

import android.util.Log
import com.example.movies.data.models.MovieModel
import com.example.movies.data.models.MoviesPageModel
import com.example.movies.data.repositories.PopularMovieRepository
import com.example.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(private val popularMovieRepository: PopularMovieRepository) {

    suspend operator fun invoke(page: Int): MoviesPageModel = popularMovieRepository.popularMovie(page)
}