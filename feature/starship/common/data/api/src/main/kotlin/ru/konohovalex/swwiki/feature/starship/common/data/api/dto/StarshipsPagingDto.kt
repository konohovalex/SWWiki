package ru.konohovalex.swwiki.feature.starship.common.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class StarshipsPagingDto(
    val count: Int,
    val results: List<StarshipDto>,
)
