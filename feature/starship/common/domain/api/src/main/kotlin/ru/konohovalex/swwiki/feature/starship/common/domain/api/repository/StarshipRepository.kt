package ru.konohovalex.swwiki.feature.starship.common.domain.api.repository

import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel

interface StarshipRepository {
    suspend fun getAllStarships(page: Int): List<StarshipModel>

    suspend fun getStarship(id: Int): StarshipModel?

    suspend fun findStarships(page: Int, query: String): List<StarshipModel>
}
