package com.prakhar_sharan.tmdbmovieclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prakhar_sharan.tmdbmovieclient.data.db.ArtistDao
import com.prakhar_sharan.tmdbmovieclient.data.db.MovieDao
import com.prakhar_sharan.tmdbmovieclient.data.db.TvShowDao
import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, Artist::class, TvShow::class],
    version = 1,
    exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
        abstract fun movieDao(): MovieDao
        abstract fun artistDao(): ArtistDao
        abstract fun tvDao(): TvShowDao
}