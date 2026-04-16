package ru.konohovalex.swwiki.feature.starship.common.data.impl.repository

import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.starship.common.data.api.database.StarshipDao
import ru.konohovalex.swwiki.feature.starship.common.data.api.dto.StarshipDto
import ru.konohovalex.swwiki.feature.starship.common.data.api.dto.StarshipsPagingDto
import ru.konohovalex.swwiki.feature.starship.common.data.api.entity.StarshipEntity
import ru.konohovalex.swwiki.feature.starship.common.data.api.network.StarshipApi
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import ru.konohovalex.swwiki.feature.starship.common.domain.api.repository.StarshipRepository
import java.io.IOException
import javax.inject.Inject

internal class StarshipRepositoryImpl
@Inject constructor(
    private val starshipCache: RuntimeCache<Int, StarshipModel>,
    private val starshipApi: StarshipApi,
    private val starshipDao: StarshipDao,
    private val dtoToEntityMapper: Mapper<StarshipDto, StarshipEntity>,
    private val entityToModelMapper: Mapper<StarshipEntity, StarshipModel>,
//    private val databaseRecordOutdatedUseCase: DatabaseRecordOutdatedUseCase<StarshipEntity>,
) : StarshipRepository {
    override suspend fun getAllStarships(page: Int): List<StarshipModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getStarship(id: Int): StarshipModel? {
        starshipCache.get(id)?.let { return it }

        getStoredStarship(id)?.let {
            val model = entityToModelMapper(it)
            starshipCache.put(model.id, model)
            return model
        }

        return getRemoteStarship(id)?.let { remote ->
            val entity = dtoToEntityMapper(remote)
            storeStarships(entity)
            val model = entityToModelMapper(entity)
            starshipCache.put(model.id, model)
            model
        }
    }

    override suspend fun findStarships(
        page: Int,
        query: String
    ): List<StarshipModel> {
        TODO("Not yet implemented")
    }

    private suspend fun getAllRemoteStarships(page: Int): StarshipsPagingDto? =
        try {
            starshipApi.getAllStarships(page)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun getRemoteStarship(id: Int): StarshipDto? = try {
        starshipApi.getStarship(id)
    } catch (_: IOException) {
        null
    } catch (_: Throwable) {
        null
    }

    private suspend fun findAllRemoteStarships(page: Int, query: String): StarshipsPagingDto? =
        try {
            starshipApi.findStarships(page, query)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun storeStarships(vararg starships: StarshipEntity) =
        starshipDao.insertOrReplace(*starships)

    private suspend fun getStoredStarship(id: Int): StarshipEntity? =
        starshipDao.get(id)?.takeIf { /*databaseRecordOutdatedUseCase(it).not()*/true }

    private suspend fun findStoredStarshipsByName(name: String): List<StarshipEntity> =
        starshipDao.findByName(name)

    private suspend fun getAllStoredStarships(): List<StarshipEntity> =
        starshipDao.getAll()

    private suspend fun deleteStoredStarships(ids: List<Int>) =
        starshipDao.delete(ids)
}
