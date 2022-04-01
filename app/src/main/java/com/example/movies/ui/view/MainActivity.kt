package com.example.movies.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.adapters.PopularMoviesAdapter
import com.example.movies.data.models.MovieModel
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.ui.viewModel.NowPlayingViewModel
import com.example.movies.ui.viewModel.PopularMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PopularMovieViewModel
    private lateinit var adapter: PopularMoviesAdapter
    private lateinit var nowPlayingViewModel: NowPlayingViewModel

    private var moviesList = mutableListOf<MovieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PopularMoviesAdapter(moviesList, this)
        binding.recyclerViewMovies.adapter = adapter
        initRecyclerView()
        filterChip()
    }

    private fun initRecyclerView() {
        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterChip() {
        binding.chipPopular.setOnClickListener {
            initPopularMovieViewModel()
            moviesList.clear()
            adapter.notifyDataSetChanged()
        }

        binding.nowPlayingChip.setOnClickListener {
            initNowPlayingViewModel()
            moviesList.clear()
            adapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initPopularMovieViewModel() {
        viewModel = ViewModelProvider(this)[PopularMovieViewModel::class.java]
        viewModel.popularMoviesLiveData.observe(this) {
            moviesList.addAll(it.movieList)
            binding.recyclerViewMovies.adapter?.notifyDataSetChanged()
        }
        viewModel.getPopularMovie(1)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initNowPlayingViewModel() {
        nowPlayingViewModel = ViewModelProvider(this)[NowPlayingViewModel::class.java]
        nowPlayingViewModel.nowPlayingLiveData.observe(this) {
            moviesList.addAll(it.movieList)
            binding.recyclerViewMovies.adapter?.notifyDataSetChanged()
        }
        nowPlayingViewModel.getNowPlayingMovie(1)
    }
}