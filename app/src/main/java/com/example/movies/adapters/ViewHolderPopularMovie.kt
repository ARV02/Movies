package com.example.movies.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.data.models.MovieModel
import com.example.movies.databinding.MoviePopularItemBinding

class ViewHolderPopularMovie(view: View):RecyclerView.ViewHolder(view) {
    private val binding = MoviePopularItemBinding.bind(view)

    fun bind(movieModel: MovieModel) {
        Glide.with(binding.poster.context).load("https://image.tmdb.org/t/p/w500/" + movieModel.poster).into(binding.poster)
        binding.title.text = movieModel.title
        binding.overView.text = movieModel.overview
    }
}