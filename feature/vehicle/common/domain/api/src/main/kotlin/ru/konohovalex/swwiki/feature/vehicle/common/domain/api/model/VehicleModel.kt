package ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model

data class VehicleModel(
    val id: Int,
    val name: String,
    val model: String,
    val vehicleClass: String,
    val manufacturer: String,
    val length: Float,
    val costInCredits: String,
    val crew: Int,
    val maxAtmospheringSpeed: Int,
    val cargoCapacity: Int,
    val consumables: String,
    val filmIds: List<Int>,
    val pilotIds: List<Int>,
)
