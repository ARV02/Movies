package com.example.movies.domain

import com.example.movies.data.database.entities.toDatabase
import com.example.movies.data.repositories.NowPlayingRepository
import com.example.movies.domain.model.NowPlaying
import javax.inject.Inject

class GetNowPlayingUseCase @Inject constructor(private val nowPlayingRepository: NowPlayingRepository) {

    suspend operator fun invoke(page: Int): List<NowPlaying> {
        val movies = nowPlayingRepository.nowPlayingMovieFromApi(page)
        return if(movies.isNotEmpty()) {
            nowPlayingRepository.deleteNowPlayingMovie()
            nowPlayingRepository.insertNowPlayingMovie(movies.map { it.toDatabase() })
            movies
        } else {
            nowPlayingRepository.nowPlayingMovieFromDB()
        }
    }
}