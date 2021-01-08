package com.prakhar_sharan.tmdbmovieclient.data.repository.movie

import android.util.Log
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieCacheDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieLocalDataSource
import com.prakhar_sharan.tmdbmovieclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.prakhar_sharan.tmdbmovieclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTagR", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
            if(movieList.size>0){
                return movieList
            }
            else{
                movieList = getMoviesFromApi()
                movieLocalDataSource.saveMoviesToDB(movieList)
            }
        }catch(exception: Exception){
            Log.i("MyTagDB", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList =movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTagCA", exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList= getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}