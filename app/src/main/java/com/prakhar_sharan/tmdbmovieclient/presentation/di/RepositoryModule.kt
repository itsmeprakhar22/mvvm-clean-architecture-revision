package com.prakhar_sharan.tmdbmovieclient.presentation.di

import com.prakhar_sharan.tmdbmovieclient.data.repository.artist.ArtistRepositoryImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.MovieRepositoryImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.*
import com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow.TvShowRepositoryImpl
import com.prakhar_sharan.tmdbmovieclient.domain.repository.ArtistRepository
import com.prakhar_sharan.tmdbmovieclient.domain.repository.MovieRepository
import com.prakhar_sharan.tmdbmovieclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource,movieLocalDataSource, movieCacheDataSource)
    }

    @Provides
    @Singleton
    fun provideTvRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ):TvShowRepository{
        return TvShowRepositoryImpl(tvShowsRemoteDataSource,tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository{
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource,artistCacheDataSource)
    }
}