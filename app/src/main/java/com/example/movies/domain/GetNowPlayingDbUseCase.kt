package com.example.movies.domain

import com.example.movies.data.repositories.NowPlayingRepository
import com.example.movies.domain.model.NowPlaying
import javax.inject.Inject

class GetNowPlayingDbUseCase @Inject constructor(private val nowPlayingRepository: NowPlayingRepository) {

    suspend operator fun invoke(): List<NowPlaying>? {
        val movies = nowPlayingRepository.nowPlayingMovieFromDB()
        if(!movies.isNullOrEmpty()) {
            return movies
        }
        return null
    }
}