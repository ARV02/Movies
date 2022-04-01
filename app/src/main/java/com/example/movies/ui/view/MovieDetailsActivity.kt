package com.example.movies.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movies.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMovieInfo()
    }

    private fun getMovieInfo() {
        val intent = intent
        val poster = intent.getStringExtra("poster").toString()
        val title = intent.getStringExtra("title").toString()
        val overview = intent.getStringExtra("overview")
        val releaseDate = intent.getStringExtra("backdrop_path").toString()

        Glide.with(binding.poster.context).load("https://image.tmdb.org/t/p/w500/$poster").into(binding.poster)
        binding.title.text = title
        binding.overView.text = overview
        binding.releaseDate.text = releaseDate
    }
}