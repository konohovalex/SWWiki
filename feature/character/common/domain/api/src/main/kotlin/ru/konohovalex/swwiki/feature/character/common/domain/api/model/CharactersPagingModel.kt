package ru.konohovalex.swwiki.feature.character.common.domain.api.model

data class CharactersPagingModel(
    val next: String?,
    val results: List<CharacterModel>,
)
