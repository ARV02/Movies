package com.example.movies.data.network

import com.example.movies.data.models.MoviesPageModel
import com.example.movies.data.models.NowPlayingResponse
import com.example.movies.data.models.VideosResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page")page: Int,
        @Query("include_adult")adult: Boolean = false,
        @Query("language")language: String = "en-US"
    ): MoviesPageModel

    @GET("movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query("page")page: Int,
        @Query("language")language: String = "en-US"
    ):NowPlayingResponse
    
    @GET("movie/{id}/videos")
    suspend fun getVideos(@Path("id")id: Int): VideosResult
}