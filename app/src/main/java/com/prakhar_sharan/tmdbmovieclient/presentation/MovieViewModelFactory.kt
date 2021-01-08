package com.prakhar_sharan.tmdbmovieclient.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prakhar_sharan.tmdbmovieclient.domain.usecases.GetMoviesUseCase
import com.prakhar_sharan.tmdbmovieclient.domain.usecases.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getMoviesUseCase, updateMovieUseCase) as T
    }
}