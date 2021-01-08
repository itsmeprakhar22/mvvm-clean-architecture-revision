package com.prakhar_sharan.tmdbmovieclient.domain.usecases

import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist
import com.prakhar_sharan.tmdbmovieclient.domain.repository.ArtistRepository

class UpdateArtistUseCase (private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}