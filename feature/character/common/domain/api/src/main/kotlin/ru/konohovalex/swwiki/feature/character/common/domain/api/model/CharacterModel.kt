package ru.konohovalex.swwiki.feature.character.common.domain.api.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: Int,
    val hairColor: String,
    val height: String,
    val mass: String,
    val skinColor: String,
    val homeworldId: Int?,
    val filmIds: List<Int>,
    val specieIds: List<Int>,
    val starshipIds: List<Int>,
    val vehicleIds: List<Int>,
)
