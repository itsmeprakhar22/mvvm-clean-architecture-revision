package com.prakhar_sharan.tmdbmovieclient.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.prakhar_sharan.tmdbmovieclient.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tvShows: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)