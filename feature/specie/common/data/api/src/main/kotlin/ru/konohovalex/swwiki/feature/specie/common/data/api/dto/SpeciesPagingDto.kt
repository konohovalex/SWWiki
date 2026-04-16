package ru.konohovalex.swwiki.feature.specie.common.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class SpeciesPagingDto(
    val count: Int,
    val results: List<SpecieDto>,
)
