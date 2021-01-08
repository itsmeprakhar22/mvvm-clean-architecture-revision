package com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource

import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(movies: List<Artist>)
    suspend fun clearAll()
}