package com.example.movies.data.network

import com.example.movies.data.models.NowPlayingResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NowPlayingService @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun nowPlaying(page: Int): NowPlayingResponse {
        return withContext(Dispatchers.IO) {
            apiInterface.getMoviesNowPlaying(page)
        }
    }
}