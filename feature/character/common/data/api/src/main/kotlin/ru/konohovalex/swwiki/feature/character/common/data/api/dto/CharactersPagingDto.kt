package ru.konohovalex.swwiki.feature.character.common.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharactersPagingDto(
    val next: String?,
    val results: List<CharacterDto>,
)
