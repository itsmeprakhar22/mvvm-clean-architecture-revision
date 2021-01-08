package com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow

import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowCacheDataSource

class TvShowsCacheDataSourceImpl:
    TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }


}