package com.example.movies.data.repositories

import com.example.movies.data.models.MoviesPageModel
import com.example.movies.data.network.NowPlayingService
import javax.inject.Inject

class NowPlayingRepository @Inject constructor(private val nowPlayingService: NowPlayingService) {

    suspend fun nowPlayingMovie(page: Int): MoviesPageModel = nowPlayingService.nowPlaying(page)
}