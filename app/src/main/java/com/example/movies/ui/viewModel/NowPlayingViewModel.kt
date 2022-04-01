package com.example.movies.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.MoviesPageModel
import com.example.movies.domain.GetNowPlayingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(private val getNowPlayingUseCase: GetNowPlayingUseCase): ViewModel() {
    val nowPlayingLiveData = MutableLiveData<MoviesPageModel>()

    fun getNowPlayingMovie(page: Int) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.i("Network", "Caught $exception")
        }
        viewModelScope.launch(handler) {
            val response = getNowPlayingUseCase.invoke(page)
            nowPlayingLiveData.postValue(response)
        }
    }
}