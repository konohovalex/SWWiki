package ru.konohovalex.swwiki.feature.planet.common.data.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class PlanetDto(
    val name: String,
    val diameter: Int,
    @SerialName("rotation_period")
    val rotationPeriod: Int,
    @SerialName("orbital_period")
    val orbitalPeriod: Int,
    val gravity: String,
    val population: Int,
    val climate: String,
    val terrain: String,
    @SerialName("surface_water")
    val surfaceWater: Int,
    @SerialName("residents")
    val residentUrls: List<String>,
    @SerialName("films")
    val filmUrls: List<String>,
    val url: String,
    @SerialName("edited")
    val editedDate: Instant,
)
