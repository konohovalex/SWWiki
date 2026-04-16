package ru.konohovalex.swwiki.feature.film.common.domain.api.model

import kotlinx.datetime.LocalDate

data class FilmModel(
    val id: Int,
    val title: String,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: LocalDate,
    val specieIds: List<Int>,
    val starshipIds: List<Int>,
    val vehicleIds: List<Int>,
    val characterIds: List<Int>,
    val planetIds: List<Int>,
)
