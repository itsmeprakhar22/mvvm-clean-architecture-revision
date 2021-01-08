package com.prakhar_sharan.tmdbmovieclient.domain.usecases

import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}