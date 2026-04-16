package ru.konohovalex.swwiki.feature.vehicle.common.domain.api.repository

import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel

interface VehicleRepository {
    suspend fun getAllVehicles(page: Int): List<VehicleModel>

    suspend fun getVehicle(id: Int): VehicleModel?

    suspend fun findVehicles(page: Int, query: String): List<VehicleModel>
}
