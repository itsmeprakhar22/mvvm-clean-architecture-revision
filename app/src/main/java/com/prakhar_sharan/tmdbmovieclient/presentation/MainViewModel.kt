package com.prakhar_sharan.tmdbmovieclient.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.domain.usecases.GetMoviesUseCase
import com.prakhar_sharan.tmdbmovieclient.domain.usecases.UpdateMovieUseCase

class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModel() {


    fun getMovies(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList: List<Movie>? = updateMovieUseCase.execute()
        emit(movieList)
    }
}