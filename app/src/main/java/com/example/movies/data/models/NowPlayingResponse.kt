package com.example.movies.data.models

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse (
    @SerializedName("results")
    val movieList: List<NowPlayingModel>
        )