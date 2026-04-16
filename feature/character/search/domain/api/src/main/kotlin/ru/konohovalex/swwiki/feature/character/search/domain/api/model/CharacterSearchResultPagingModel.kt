package ru.konohovalex.swwiki.feature.character.search.domain.api.model

data class CharacterSearchResultPagingModel(
    val next: String?,
    val results: List<CharacterSearchResultModel>,
)
