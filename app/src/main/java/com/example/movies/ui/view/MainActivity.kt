package com.example.movies.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.adapters.NowPlayingAdapter
import com.example.movies.adapters.PopularMoviesAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.domain.model.Movie
import com.example.movies.domain.model.NowPlaying
import com.example.movies.ui.viewModel.NowPlayingViewModel
import com.example.movies.ui.viewModel.PopularMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PopularMoviesAdapter
    private lateinit var nowAdapter: NowPlayingAdapter

    private val viewModel: PopularMovieViewModel by viewModels()
    private val nowPlayingViewModel: NowPlayingViewModel by viewModels()

    private var moviesList = mutableListOf<Movie>()
    private var nowPlayingList = mutableListOf<NowPlaying>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PopularMoviesAdapter(moviesList, this)
        nowAdapter = NowPlayingAdapter(nowPlayingList, this)
        binding.recyclerViewMovies.adapter = adapter
        initRecyclerView()
        filterChip()
    }

    private fun initRecyclerView() {
        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterChip() {
        initPopularMovieViewModel()
        binding.chipPopular.setOnClickListener {
            binding.recyclerViewMovies.adapter = adapter
            viewModel.popularMovies()
            nowPlayingList.clear()
            nowAdapter.notifyDataSetChanged()
        }

        initNowPlayingViewModel()
        binding.nowPlayingChip.setOnClickListener {
            binding.recyclerViewMovies.adapter = nowAdapter
            nowPlayingViewModel.nowPlayingMovies()
            moviesList.clear()
            adapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initPopularMovieViewModel() {
        viewModel.popularMoviesLiveData.observe(this) {
            moviesList.addAll(it)
            binding.recyclerViewMovies.adapter?.notifyDataSetChanged()
        }
        viewModel.onCreate(1)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initNowPlayingViewModel() {
        nowPlayingViewModel.nowPlayingLiveData.observe(this) {
            nowPlayingList.addAll(it)
            binding.recyclerViewMovies.adapter?.notifyDataSetChanged()
        }
        nowPlayingViewModel.onCreate(1)
    }
}