package com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow

import com.prakhar_sharan.tmdbmovieclient.data.db.ArtistDao
import com.prakhar_sharan.tmdbmovieclient.data.db.MovieDao
import com.prakhar_sharan.tmdbmovieclient.data.db.TvShowDao
import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.ArtistLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(private val tvShowDao: TvShowDao) :
    TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        tvShowDao.saveTvShows(tvShows)
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}