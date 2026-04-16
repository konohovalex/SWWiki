package ru.konohovalex.swwiki.feature.planet.common.domain.api.model

data class PlanetModel(
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
)
