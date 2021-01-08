package com.prakhar_sharan.tmdbmovieclient.data.repository.artist

import com.prakhar_sharan.tmdbmovieclient.data.api.TMDBService
import com.prakhar_sharan.tmdbmovieclient.data.model.artist.ArtistList
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) :
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }

}