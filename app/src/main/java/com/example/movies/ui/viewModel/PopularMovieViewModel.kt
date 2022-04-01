package com.example.movies.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.MoviesPageModel
import com.example.movies.domain.GetPopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(private val getPopularMovieUseCase: GetPopularMovieUseCase): ViewModel() {

    val popularMoviesLiveData = MutableLiveData<MoviesPageModel>()

    fun getPopularMovie(page: Int) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.d("Network", "Caught $exception")
        }
        viewModelScope.launch(handler) {
            val result = getPopularMovieUseCase.invoke(page)
                popularMoviesLiveData.postValue(result)
        }
    }
}