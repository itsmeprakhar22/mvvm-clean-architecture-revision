package com.prakhar_sharan.tmdbmovieclient.presentation.di

import com.prakhar_sharan.tmdbmovieclient.presentation.di.movie.MovieSubComponent
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules=[
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
}