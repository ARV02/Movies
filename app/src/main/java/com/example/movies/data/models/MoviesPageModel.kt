package com.example.movies.data.models

import com.google.gson.annotations.SerializedName

data class MoviesPageModel(
    /*@SerializedName("page")
    val page: Int,*/
    @SerializedName("results")
    val movieList: List<MovieModel>
)
