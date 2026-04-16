package ru.konohovalex.swwiki.feature.specie.common.domain.api.repository

import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel

interface SpecieRepository {
    suspend fun getAllSpecies(page: Int): List<SpecieModel>

    suspend fun getSpecie(id: Int): SpecieModel?

    suspend fun findSpecies(page: Int, query: String): List<SpecieModel>
}
