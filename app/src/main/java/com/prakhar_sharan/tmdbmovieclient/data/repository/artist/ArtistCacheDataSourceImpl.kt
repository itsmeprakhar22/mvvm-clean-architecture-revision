package com.prakhar_sharan.tmdbmovieclient.data.repository.artist

import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieCacheDataSource

class ArtistCacheDataSourceImpl:
    ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }


}