package com.prakhar_sharan.tmdbmovieclient.presentation.di

import com.prakhar_sharan.tmdbmovieclient.data.db.ArtistDao
import com.prakhar_sharan.tmdbmovieclient.data.db.MovieDao
import com.prakhar_sharan.tmdbmovieclient.data.db.TvShowDao
import com.prakhar_sharan.tmdbmovieclient.data.repository.artist.ArtistLocalDataSourceImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.MovieLocalDataSourceImpl
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDatSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvLocalDatSource(tvShowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowsLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDatSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

}