package com.prakhar_sharan.tmdbmovieclient.domain.usecases

import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow
import com.prakhar_sharan.tmdbmovieclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase (private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}