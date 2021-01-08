package com.prakhar_sharan.tmdbmovieclient.presentation.di

import com.prakhar_sharan.tmdbmovieclient.presentation.di.movie.MovieSubComponent


interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
}