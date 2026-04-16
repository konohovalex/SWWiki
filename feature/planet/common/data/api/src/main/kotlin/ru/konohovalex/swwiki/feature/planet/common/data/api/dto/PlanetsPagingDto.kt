package ru.konohovalex.swwiki.feature.planet.common.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlanetsPagingDto(
    val count: Int,
    val results: List<PlanetDto>,
)
