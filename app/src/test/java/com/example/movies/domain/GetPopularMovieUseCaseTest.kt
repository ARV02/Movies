package com.example.movies.domain

import com.example.movies.data.repositories.PopularMovieRepository
import com.example.movies.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPopularMovieUseCaseTest {

    @RelaxedMockK
    private lateinit var popularMovieRepository: PopularMovieRepository

    private lateinit var getPopularMovieUseCase: GetPopularMovieUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getPopularMovieUseCase = GetPopularMovieUseCase(popularMovieRepository)
    }

    @Test
    fun `when the api doesn't return anything get values from DB` () = runBlocking {
        //Given
        coEvery { popularMovieRepository.getPopularMovieFromApi(1) } returns emptyList()

        //When
        getPopularMovieUseCase(1)

        //Then
        coVerify(exactly = 1) { popularMovieRepository.getPopularMoviesFromDB() }
    }

    @Test
    fun `when the return something then get values from api`() = runBlocking {
        //Given
        val mList = listOf(Movie(2342, "movie", "image.jpg","2022-04-02","action"))
        coEvery { popularMovieRepository.getPopularMovieFromApi(1) } returns mList

        //When
        val response = getPopularMovieUseCase(1)

        //Then
        coVerify(exactly = 1) { popularMovieRepository.clearMovies() }
        coVerify(exactly = 1) { popularMovieRepository.insertPopularMovies(any()) }
        coVerify(exactly = 0) { popularMovieRepository.getPopularMoviesFromDB() }
        assert(mList == response)
    }
}