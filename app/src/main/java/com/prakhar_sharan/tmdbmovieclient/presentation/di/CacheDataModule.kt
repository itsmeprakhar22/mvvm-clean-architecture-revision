package com.prakhar_sharan.tmdbmovieclient.presentation.di

import com.prakhar_sharan.tmdbmovieclient.data.repository.artist.ArtistCacheDataSourceImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.MovieCacheDataSourceImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvCacheDataSource(): TvShowCacheDataSource{
        return TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}