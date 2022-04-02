package com.example.movies.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movies.BuildConfig
import com.example.movies.R
import com.example.movies.databinding.ActivityMovieDetailsBinding
import com.example.movies.ui.viewModel.VideoViewModel
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    private val videoViewModel: VideoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMovieInfo()
        getVideo()
    }

    private fun getMovieInfo() {
        val intent = intent
        val poster = intent.getStringExtra("poster").toString()
        val title = intent.getStringExtra("title").toString()
        val overview = intent.getStringExtra("overview")
        val releaseDate = intent.getStringExtra("release_date").toString()

        Glide.with(binding.poster.context).load("https://image.tmdb.org/t/p/w500/$poster").into(binding.poster)
        binding.title.text = title
        binding.overView.text = overview
        binding.releaseDate.text = releaseDate
    }

    private fun getVideo() {
        val intent = intent
        val id = intent.getIntExtra("id",0)
        videoViewModel.videoLiveData.observe(this) { result ->
            Log.i("Video", "${result.videosList.map { it.key }}")
            val list = result.videosList.map { it.key }
            val key = list.first()
            lifecycle.addObserver(binding.video)
            binding.video.addYouTubePlayerListener(object: AbstractYouTubePlayerListener() {

                override fun onReady(youTubePlayer: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(key, 0F)
                }
            })
        }
        508947
        videoViewModel.getVideo(id)
    }
}