package com.example.movies.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.VideosResult
import com.example.movies.domain.GetVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(private val getVideoUseCase: GetVideoUseCase): ViewModel() {
    val videoLiveData = MutableLiveData<VideosResult>()

    fun getVideo(id: Int) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.i("Network", "Caught $exception")
        }
        viewModelScope.launch(handler) {
            val result = getVideoUseCase(id)
            videoLiveData.postValue(result
            )
        }
    }
}