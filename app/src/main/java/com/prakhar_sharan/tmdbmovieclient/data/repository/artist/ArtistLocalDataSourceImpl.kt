package com.prakhar_sharan.tmdbmovieclient.data.repository.artist

import com.prakhar_sharan.tmdbmovieclient.data.db.ArtistDao
import com.prakhar_sharan.tmdbmovieclient.data.db.MovieDao
import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) :
    ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        artistDao.saveArtists(artists)
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}