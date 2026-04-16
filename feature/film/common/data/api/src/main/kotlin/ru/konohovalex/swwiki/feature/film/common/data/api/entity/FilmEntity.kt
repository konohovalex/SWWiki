package ru.konohovalex.swwiki.feature.film.common.data.api.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "film")
data class FilmEntity(
    @PrimaryKey
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
    val editedDate: LocalDateTime,
)
