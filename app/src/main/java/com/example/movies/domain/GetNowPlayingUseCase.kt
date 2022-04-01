package com.example.movies.domain

import com.example.movies.data.models.MoviesPageModel
import com.example.movies.data.repositories.NowPlayingRepository
import javax.inject.Inject

class GetNowPlayingUseCase @Inject constructor(private val nowPlayingRepository: NowPlayingRepository) {

    suspend operator fun invoke(page: Int): MoviesPageModel = nowPlayingRepository.nowPlayingMovie(page)
}