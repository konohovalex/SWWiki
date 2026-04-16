package ru.konohovalex.swwiki.feature.specie.common.data.impl.repository

import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.specie.common.data.api.database.SpecieDao
import ru.konohovalex.swwiki.feature.specie.common.data.api.dto.SpecieDto
import ru.konohovalex.swwiki.feature.specie.common.data.api.dto.SpeciesPagingDto
import ru.konohovalex.swwiki.feature.specie.common.data.api.entity.SpecieEntity
import ru.konohovalex.swwiki.feature.specie.common.data.api.network.SpecieApi
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import ru.konohovalex.swwiki.feature.specie.common.domain.api.repository.SpecieRepository
import java.io.IOException
import javax.inject.Inject

internal class SpecieRepositoryImpl
@Inject constructor(
    private val specieCache: RuntimeCache<Int, SpecieModel>,
    private val specieApi: SpecieApi,
    private val specieDao: SpecieDao,
    private val dtoToEntityMapper: Mapper<SpecieDto, SpecieEntity>,
    private val entityToModelMapper: Mapper<SpecieEntity, SpecieModel>,
//    private val databaseRecordOutdatedUseCase: DatabaseRecordOutdatedUseCase<SpecieEntity>,
) : SpecieRepository {
    override suspend fun getAllSpecies(page: Int): List<SpecieModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpecie(id: Int): SpecieModel? {
        specieCache.get(id)?.let { return it }

        getStoredSpecie(id)?.let {
            val model = entityToModelMapper(it)
            specieCache.put(model.id, model)
            return model
        }

        return getRemoteSpecie(id)?.let { remote ->
            val entity = dtoToEntityMapper(remote)
            storeSpecies(entity)
            val model = entityToModelMapper(entity)
            specieCache.put(model.id, model)
            model
        }
    }

    override suspend fun findSpecies(
        page: Int,
        query: String
    ): List<SpecieModel> {
        TODO("Not yet implemented")
    }

    private suspend fun getAllRemoteSpecies(page: Int): SpeciesPagingDto? =
        try {
            specieApi.getAllSpecies(page)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun getRemoteSpecie(id: Int): SpecieDto? = try {
        specieApi.getSpecie(id)
    } catch (_: IOException) {
        null
    } catch (_: Throwable) {
        null
    }

    private suspend fun findAllRemoteSpecies(page: Int, query: String): SpeciesPagingDto? =
        try {
            specieApi.findSpecies(page, query)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun storeSpecies(vararg species: SpecieEntity) =
        specieDao.insertOrReplace(*species)

    private suspend fun getStoredSpecie(id: Int): SpecieEntity? =
        specieDao.get(id)?.takeIf { /*databaseRecordOutdatedUseCase(it).not()*/true }

    private suspend fun findStoredSpeciesByName(name: String): List<SpecieEntity> =
        specieDao.findByName(name)

    private suspend fun getAllStoredSpecies(): List<SpecieEntity> =
        specieDao.getAll()

    private suspend fun deleteStoredSpecies(ids: List<Int>) =
        specieDao.delete(ids)
}
