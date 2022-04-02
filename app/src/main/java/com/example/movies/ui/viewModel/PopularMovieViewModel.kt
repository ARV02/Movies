package com.example.movies.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.domain.GetPopularMovieDbUseCase
import com.example.movies.domain.GetPopularMovieUseCase
import com.example.movies.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(private val getPopularMovieUseCase: GetPopularMovieUseCase, private val getPopularMovieDbUseCase: GetPopularMovieDbUseCase): ViewModel() {

    val popularMoviesLiveData = MutableLiveData<List<Movie>>()

    fun onCreate(page: Int) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.d("Network", "Caught $exception")
        }
        viewModelScope.launch(handler) {
            val result = getPopularMovieUseCase(page)
                popularMoviesLiveData.postValue(result)
        }
    }

    fun popularMovies() {
        viewModelScope.launch() {
            val movies = getPopularMovieDbUseCase()
            if(movies != null) {
                popularMoviesLiveData.postValue(movies)
            }
        }
    }
}