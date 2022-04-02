package com.example.movies.data.network

import com.example.movies.data.models.VideosResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VideoService @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getVideo(id: Int): VideosResult {
        return withContext(Dispatchers.IO) {
            apiInterface.getVideos(id)
        }
    }
}