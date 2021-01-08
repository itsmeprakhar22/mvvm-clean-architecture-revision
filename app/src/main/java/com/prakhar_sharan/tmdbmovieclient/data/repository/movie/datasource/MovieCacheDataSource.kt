package com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource

import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}