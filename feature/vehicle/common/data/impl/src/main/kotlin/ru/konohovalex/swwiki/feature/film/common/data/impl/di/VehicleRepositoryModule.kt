package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.film.common.data.impl.repository.VehicleRepositoryImpl
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.database.VehicleDao
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto.VehicleDto
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity.VehicleEntity
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.network.VehicleApi
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.repository.VehicleRepository

@Module
internal class VehicleRepositoryModule {
    @Provides
    fun bindFilmRepository(
        vehicleCache: RuntimeCache<Int, VehicleModel>,
        vehicleApi: VehicleApi,
        vehicleDao: VehicleDao,
        dtoToEntityMapper: Mapper<VehicleDto, VehicleEntity>,
        entityToModelMapper: Mapper<VehicleEntity, VehicleModel>,
    ): VehicleRepository = VehicleRepositoryImpl(
        vehicleCache,
        vehicleApi,
        vehicleDao,
        dtoToEntityMapper,
        entityToModelMapper,
    )
}
