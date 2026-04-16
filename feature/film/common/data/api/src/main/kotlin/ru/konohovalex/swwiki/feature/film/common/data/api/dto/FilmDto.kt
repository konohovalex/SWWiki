package ru.konohovalex.swwiki.feature.film.common.data.api.dto

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class FilmDto(
    val title: String,
    @SerialName("opening_crawl")
    val openingCrawl: String,
    val director: String,
    val producer: String,
    @SerialName("release_date")
    val releaseDate: LocalDate,
    @SerialName("species")
    val specieUrls: List<String>,
    @SerialName("starships")
    val starshipUrls: List<String>,
    @SerialName("vehicles")
    val vehicleUrls: List<String>,
    @SerialName("characters")
    val characterUrls: List<String>,
    @SerialName("planets")
    val planetUrls: List<String>,
    val url: String,
    @SerialName("edited")
    val editedDate: Instant,
)
