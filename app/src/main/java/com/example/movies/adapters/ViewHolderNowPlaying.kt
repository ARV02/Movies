package com.example.movies.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.databinding.MoviePopularItemBinding
import com.example.movies.domain.model.Movie
import com.example.movies.domain.model.NowPlaying

class ViewHolderNowPlaying(view: View): RecyclerView.ViewHolder(view) {
    private val binding = MoviePopularItemBinding.bind(view)

    fun bind(nowPlaying: NowPlaying) {
        Glide.with(binding.poster.context).load("https://image.tmdb.org/t/p/w500/" + nowPlaying.poster).into(binding.poster)
        binding.title.text = nowPlaying.title
        binding.overView.text = nowPlaying.overview
    }
}