package ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class VehicleDto(
    val name: String,
    val model: String,
    @SerialName("vehicle_class")
    val vehicleClass: String,
    val manufacturer: String,
    val length: Float,
    @SerialName("cost_in_credits")
    val costInCredits: String,
    val crew: Int,
    @SerialName("max_atmosphering_speed")
    val maxAtmospheringSpeed: Int,
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
