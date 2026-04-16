package ru.konohovalex.swwiki.feature.planet.common.data.impl.repository

import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.planet.common.data.api.database.PlanetDao
import ru.konohovalex.swwiki.feature.planet.common.data.api.dto.PlanetDto
import ru.konohovalex.swwiki.feature.planet.common.data.api.dto.PlanetsPagingDto
import ru.konohovalex.swwiki.feature.planet.common.data.api.entity.PlanetEntity
import ru.konohovalex.swwiki.feature.planet.common.data.api.network.PlanetApi
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import ru.konohovalex.swwiki.feature.planet.common.domain.api.repository.PlanetRepository
import java.io.IOException
import javax.inject.Inject

internal class PlanetRepositoryImpl
@Inject constructor(
    private val planetCache: RuntimeCache<Int, PlanetModel>,
    private val planetApi: PlanetApi,
    private val planetDao: PlanetDao,
    private val dtoToEntityMapper: Mapper<PlanetDto, PlanetEntity>,
    private val entityToModelMapper: Mapper<PlanetEntity, PlanetModel>,
//    private val databaseRecordOutdatedUseCase: DatabaseRecordOutdatedUseCase<PlanetEntity>,
) : PlanetRepository {
    override suspend fun getAllPlanets(page: Int): List<PlanetModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlanet(id: Int): PlanetModel? {
        planetCache.get(id)?.let { return it }

        getStoredPlanet(id)?.let {
            val model = entityToModelMapper(it)
            planetCache.put(model.id, model)
            return model
        }

        return getRemotePlanet(id)?.let { remote ->
            val entity = dtoToEntityMapper(remote)
            storePlanets(entity)
            val model = entityToModelMapper(entity)
            planetCache.put(model.id, model)
            model
        }
    }

    override suspend fun findPlanets(
        page: Int,
        query: String
    ): List<PlanetModel> {
        TODO("Not yet implemented")
    }

    private suspend fun getAllRemotePlanets(page: Int): PlanetsPagingDto? =
        try {
            planetApi.getAllPlanets(page)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun getRemotePlanet(id: Int): PlanetDto? = try {
        planetApi.getPlanet(id)
    } catch (_: IOException) {
        null
    } catch (_: Throwable) {
        null
    }

    private suspend fun findAllRemotePlanets(page: Int, query: String): PlanetsPagingDto? =
        try {
            planetApi.findPlanets(page, query)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun storePlanets(vararg planets: PlanetEntity) =
        planetDao.insertOrReplace(*planets)

    private suspend fun getStoredPlanet(id: Int): PlanetEntity? =
        planetDao.get(id)?.takeIf { /*databaseRecordOutdatedUseCase(it).not()*/true }

    private suspend fun findStoredPlanetsByName(name: String): List<PlanetEntity> =
        planetDao.findByName(name)

    private suspend fun getAllStoredPlanets(): List<PlanetEntity> =
        planetDao.getAll()

    private suspend fun deleteStoredPlanets(ids: List<String>) =
        planetDao.delete(ids)
}
