package com.example.movies.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.MoviesPageModel
import com.example.movies.domain.GetNowPlayingDbUseCase
import com.example.movies.domain.GetNowPlayingUseCase
import com.example.movies.domain.model.NowPlaying
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(private val getNowPlayingUseCase: GetNowPlayingUseCase, private val getNowPlayingDbUseCase: GetNowPlayingDbUseCase): ViewModel() {
    val nowPlayingLiveData = MutableLiveData<List<NowPlaying>>()

    fun onCreate(page: Int) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.i("Network", "Caught $exception")
        }
        viewModelScope.launch(handler) {
            val response = getNowPlayingUseCase.invoke(page)
            nowPlayingLiveData.postValue(response)
        }
    }

    fun nowPlayingMovies() {
        viewModelScope.launch() {
            val movies = getNowPlayingDbUseCase()
            if(movies != null) {
                nowPlayingLiveData.postValue(movies)
            }
        }
    }
}