package ru.konohovalex.swwiki.feature.planet.common.domain.api.repository

import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel

interface PlanetRepository {
    suspend fun getAllPlanets(page: Int): List<PlanetModel>

    suspend fun getPlanet(id: Int): PlanetModel?

    suspend fun findPlanets(page: Int, query: String): List<PlanetModel>
}
