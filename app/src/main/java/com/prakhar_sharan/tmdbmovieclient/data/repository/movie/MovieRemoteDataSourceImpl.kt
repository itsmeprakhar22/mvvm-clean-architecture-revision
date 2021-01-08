package com.prakhar_sharan.tmdbmovieclient.data.repository.movie

import com.prakhar_sharan.tmdbmovieclient.data.api.TMDBService
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}