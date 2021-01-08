package com.prakhar_sharan.tmdbmovieclient.presentation.di.movie

import com.prakhar_sharan.tmdbmovieclient.domain.usecases.GetArtistsUseCase
import com.prakhar_sharan.tmdbmovieclient.domain.usecases.GetMoviesUseCase
import com.prakhar_sharan.tmdbmovieclient.domain.usecases.UpdateArtistUseCase
import com.prakhar_sharan.tmdbmovieclient.domain.usecases.UpdateMovieUseCase
import com.prakhar_sharan.tmdbmovieclient.presentation.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
    updateMovieUseCase: UpdateMovieUseCase): MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMovieUseCase
        )
    }
}