package com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource

import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(movies: List<Artist>)
}