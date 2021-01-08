package com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource

import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow
import retrofit2.Response

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}