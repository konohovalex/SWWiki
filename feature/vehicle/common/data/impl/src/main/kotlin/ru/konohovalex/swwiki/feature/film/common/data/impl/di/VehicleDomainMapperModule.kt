package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.film.common.data.impl.mapper.VehicleDtoToVehicleEntityMapper
import ru.konohovalex.swwiki.feature.film.common.data.impl.mapper.VehicleEntityToVehicleModelMapper
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto.VehicleDto
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity.VehicleEntity
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel

@Module
internal interface VehicleDomainMapperModule {
    @Binds
    fun bindVehicleDtoToVehicleEntityMapper(
        impl: VehicleDtoToVehicleEntityMapper
    ): Mapper<VehicleDto, VehicleEntity>

    @Binds
    fun bindVehicleEntityToVehicleModelMapper(
        impl: VehicleEntityToVehicleModelMapper
    ): Mapper<VehicleEntity, VehicleModel>
}
