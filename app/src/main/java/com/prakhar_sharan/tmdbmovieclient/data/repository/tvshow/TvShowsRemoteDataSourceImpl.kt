package com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow

import com.prakhar_sharan.tmdbmovieclient.data.api.TMDBService
import com.prakhar_sharan.tmdbmovieclient.data.model.artist.ArtistList
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.MovieList
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShowList
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) :
    TvShowsRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }

}