package com.example.movies.data.repositories

import com.example.movies.data.models.VideosResult
import com.example.movies.data.network.VideoService
import javax.inject.Inject

class VideoRepository @Inject constructor(private val videoService: VideoService) {

    suspend fun getVideo(id: Int): VideosResult = videoService.getVideo(id)
}