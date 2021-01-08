package com.prakhar_sharan.tmdbmovieclient.domain.repository

import com.prakhar_sharan.tmdbmovieclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?   //Null safe
    suspend fun updateArtists(): List<Artist>?   //Null safe
}