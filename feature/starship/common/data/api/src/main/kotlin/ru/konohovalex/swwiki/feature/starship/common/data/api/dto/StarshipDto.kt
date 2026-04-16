package ru.konohovalex.swwiki.feature.starship.common.data.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class StarshipDto(
    val name: String,
    val model: String,
    @SerialName("starship_class")
    val starshipClass: String,
    val manufacturer: String,
    @SerialName("cost_in_credits")
    val costInCredits: String,
    val length: Float,
    val crew: Int,
    val passengers: Int,
    @SerialName("max_atmosphering_speed")
    val maxAtmospheringSpeed: Int,
    @SerialName("hyperdrive_rating")
    val hyperdriveRating: Float,
    @SerialName("MGLT")
    val mglt: String,
    @SerialName("cargo_capacity")
    val cargoCapacity: Int,
    val consumables: String,
    @SerialName("films")
    val filmUrls: List<String>,
    @SerialName("pilots")
    val pilotUrls: List<String>,
    val url: String,
    @SerialName("edited")
    val editedDate: Instant,
)
