package com.prakhar_sharan.tmdbmovieclient.domain.repository

import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?   //Null safe
    suspend fun updateTvShows(): List<TvShow>?   //Null safe
}