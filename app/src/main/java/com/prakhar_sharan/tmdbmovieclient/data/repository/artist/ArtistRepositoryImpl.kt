package com.prakhar_sharan.tmdbmovieclient.data.repository.artist

import android.util.Log
import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.*
import com.prakhar_sharan.tmdbmovieclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource ,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var movieList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                movieList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var movieList: List<Artist>

        try {
            movieList = artistLocalDataSource.getArtistsFromDB()
            if (movieList.size > 0) {
                return movieList
            } else {
                movieList = getArtistsFromApi()
                artistLocalDataSource.saveArtistsToDB(movieList)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var movieList: List<Artist>
        try {
            movieList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(movieList)
        }
        return movieList
    }
}