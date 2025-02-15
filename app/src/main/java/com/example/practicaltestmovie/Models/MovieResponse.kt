package com.example.practicaltestmovie.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val results: List<Movie>
)

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("vote_average") val rating: Double,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("overview") val overview: String,
    @SerialName("adult") val isAdult: Boolean,
    @SerialName("genre_ids") val genreIds: List<Int> = emptyList()
) {
    fun getFullPosterPath(): String {
        return "https://image.tmdb.org/t/p/w500$posterPath"
    }
}
