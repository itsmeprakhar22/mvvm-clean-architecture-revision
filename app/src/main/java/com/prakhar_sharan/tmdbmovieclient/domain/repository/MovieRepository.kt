package com.prakhar_sharan.tmdbmovieclient.domain.repository

import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?   //Null safe
    suspend fun updateMovies(): List<Movie>?   //Null safe
}