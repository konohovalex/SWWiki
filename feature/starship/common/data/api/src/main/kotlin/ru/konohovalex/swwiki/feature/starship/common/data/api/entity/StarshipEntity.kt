package ru.konohovalex.swwiki.feature.starship.common.data.api.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "starship")
data class StarshipEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val model: String,
    val starshipClass: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: Float,
    val crew: Int,
    val passengers: Int,
    val maxAtmospheringSpeed: Int,
    val hyperdriveRating: Float,
    val mglt: String,
    val cargoCapacity: Int,
    val consumables: String,
    val filmIds: List<Int>,
    val pilotIds: List<Int>,
    val editedDate: LocalDateTime,
)
