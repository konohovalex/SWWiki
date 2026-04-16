package ru.konohovalex.swwiki.feature.film.common.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class FilmsPagingDto(
    val count: Int,
    val results: List<FilmDto>,
)
