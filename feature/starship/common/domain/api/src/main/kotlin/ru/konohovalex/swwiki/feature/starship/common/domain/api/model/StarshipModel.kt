package ru.konohovalex.swwiki.feature.starship.common.domain.api.model

data class StarshipModel(
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
)
