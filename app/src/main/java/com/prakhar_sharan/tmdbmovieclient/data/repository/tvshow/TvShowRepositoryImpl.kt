package com.prakhar_sharan.tmdbmovieclient.data.repository.tvshow

import android.util.Log
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.TvShowsRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowsRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList=getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList =tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList=getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList
    }
}