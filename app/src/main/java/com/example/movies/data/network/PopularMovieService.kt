package com.example.movies.data.network

import com.example.movies.data.models.MoviesPageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularMovieService @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun movieMostPopular(page: Int): MoviesPageModel {
        return withContext(Dispatchers.IO) {
            apiInterface.getPopularMovies(page)
        }
    }
}