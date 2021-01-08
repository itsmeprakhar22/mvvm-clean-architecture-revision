package com.prakhar_sharan.tmdbmovieclient.presentation.di

import com.prakhar_sharan.tmdbmovieclient.data.api.TMDBService
import com.prakhar_sharan.tmdbmovieclient.data.repository.artist.ArtistRemoteDataSourceImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.MovieRemoteDataSourceImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowsRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow.TvShowsRemoteDataSourceImpl
import dagger.MapKey
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowsRemoteDataSource{
        return TvShowsRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }
}