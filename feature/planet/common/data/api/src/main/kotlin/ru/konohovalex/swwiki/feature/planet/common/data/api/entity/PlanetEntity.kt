package ru.konohovalex.swwiki.feature.planet.common.data.api.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "planet")
data class PlanetEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val diameter: Int,
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    val gravity: String,
    val population: Int,
    val climate: String,
    val terrain: String,
    val surfaceWater: Int,
    val residentIds: List<Int>,
    val filmIds: List<Int>,
    val editedDate: LocalDateTime,
)
