package com.prakhar_sharan.tmdbmovieclient.presentation.di

import android.content.Context
import androidx.room.Room
import com.prakhar_sharan.tmdbmovieclient.data.api.TMDBService
import com.prakhar_sharan.tmdbmovieclient.data.db.ArtistDao
import com.prakhar_sharan.tmdbmovieclient.data.db.MovieDao
import com.prakhar_sharan.tmdbmovieclient.data.db.TMDBDatabase
import com.prakhar_sharan.tmdbmovieclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
}