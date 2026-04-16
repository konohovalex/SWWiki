package ru.konohovalex.swwiki.feature.specie.common.domain.api.model

data class SpecieModel(
    val id: Int,
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val averageLifespan: String,
    val eyeColors: String,
    val hairColors: String,
    val skinColors: String,
    val language: String,
    val homeworldId: Int?,
    val characterId: List<Int>,
    val filmIds: List<Int>,
)
