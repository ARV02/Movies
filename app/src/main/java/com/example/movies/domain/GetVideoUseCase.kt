package com.example.movies.domain

import com.example.movies.data.models.VideosResult
import com.example.movies.data.repositories.VideoRepository
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(private val videoRepository: VideoRepository) {

    suspend operator fun invoke(id: Int):VideosResult = videoRepository.getVideo(id)
}