package com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource

import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}