package ru.konohovalex.swwiki.feature.film.common.data.impl.repository

import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.database.VehicleDao
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto.VehicleDto
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto.VehiclePagingDto
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity.VehicleEntity
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.network.VehicleApi
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.repository.VehicleRepository
import java.io.IOException
import javax.inject.Inject

internal class VehicleRepositoryImpl
@Inject constructor(
    private val vehicleCache: RuntimeCache<Int, VehicleModel>,
    private val vehicleApi: VehicleApi,
    private val vehicleDao: VehicleDao,
    private val dtoToEntityMapper: Mapper<VehicleDto, VehicleEntity>,
    private val entityToModelMapper: Mapper<VehicleEntity, VehicleModel>,
//    private val databaseRecordOutdatedUseCase: DatabaseRecordOutdatedUseCase<VehicleEntity>,
) : VehicleRepository {
    override suspend fun getAllVehicles(page: Int): List<VehicleModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getVehicle(id: Int): VehicleModel? {
        vehicleCache.get(id)?.let { return it }

        getStoredVehicle(id)?.let {
            val model = entityToModelMapper(it)
            vehicleCache.put(model.id, model)
            return model
        }

        return getRemoteVehicle(id)?.let { remote ->
            val entity = dtoToEntityMapper(remote)
            storeVehicles(entity)
            val model = entityToModelMapper(entity)
            vehicleCache.put(model.id, model)
            model
        }
    }

    override suspend fun findVehicles(
        page: Int,
        query: String
    ): List<VehicleModel> {
        TODO("Not yet implemented")
    }

    private suspend fun getAllRemoteVehicles(page: Int): VehiclePagingDto? =
        try {
            vehicleApi.getAllVehicles(page)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun getRemoteVehicle(id: Int): VehicleDto? = try {
        vehicleApi.getVehicle(id)
    } catch (_: IOException) {
        null
    } catch (_: Throwable) {
        null
    }

    private suspend fun findAllRemoteVehicles(page: Int, query: String): VehiclePagingDto? =
        try {
            vehicleApi.findVehicles(page, query)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun storeVehicles(vararg vehicles: VehicleEntity) =
        vehicleDao.insertOrReplace(*vehicles)

    private suspend fun getStoredVehicle(id: Int): VehicleEntity? =
        vehicleDao.get(id)?.takeIf { /*databaseRecordOutdatedUseCase(it).not()*/true }

    private suspend fun findStoredVehiclesByTitle(title: String): List<VehicleEntity> =
        vehicleDao.findByName(title)

    private suspend fun getAllStoredVehicles(): List<VehicleEntity> =
        vehicleDao.getAll()

    private suspend fun deleteStoredVehicles(ids: List<Int>) =
        vehicleDao.delete(ids)
}
