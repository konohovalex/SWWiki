package ru.konohovalex.swwiki.feature.character.search.domain.api.model

data class CharacterSearchResultModel(
    val id: Int,
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: Int,
    val hairColor: String,
    val height: String,
    val mass: String,
    val skinColor: String,
)
