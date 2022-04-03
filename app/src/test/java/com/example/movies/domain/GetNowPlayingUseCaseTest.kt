package com.example.movies.domain

import com.example.movies.data.repositories.NowPlayingRepository
import com.example.movies.domain.model.NowPlaying
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any

class GetNowPlayingUseCaseTest {

    @RelaxedMockK
    private lateinit var nowPlayingRepository: NowPlayingRepository

    private lateinit var getNowPlayingUseCase: GetNowPlayingUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getNowPlayingUseCase = GetNowPlayingUseCase(nowPlayingRepository)
    }

    @Test
    fun `when the api doesn't return anything get values from DB` () = runBlocking {
        //Given
        coEvery { nowPlayingRepository.nowPlayingMovieFromApi(any())} returns emptyList()

        //When
        getNowPlayingUseCase

        //Then
        coVerify(exactly = 1) { nowPlayingRepository.nowPlayingMovieFromDB() }
    }

    @Test
    fun `when the return something then get values from api`() = runBlocking {
        //Given
        val mList = listOf(NowPlaying(2342, "movie", "image.jpg","2022-04-02","action"))
        coEvery { nowPlayingRepository.nowPlayingMovieFromApi(any())} returns mList

        //When
        val response = getNowPlayingUseCase(any())

        //Then
        coVerify(exactly = 1) { nowPlayingRepository.deleteNowPlayingMovie() }
        coVerify(exactly = 1) { nowPlayingRepository.insertNowPlayingMovie(any()) }
        coVerify(exactly = 0) { nowPlayingRepository.nowPlayingMovieFromDB() }
        assert(mList == response)
    }
}