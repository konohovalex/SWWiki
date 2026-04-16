package ru.konohovalex.swwiki.feature.film.common.data.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity.VehicleEntity
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel
import javax.inject.Inject

internal class VehicleEntityToVehicleModelMapper
@Inject constructor() : Mapper<VehicleEntity, VehicleModel> {
    override fun invoke(source: VehicleEntity): VehicleModel = with(source) {
        VehicleModel(
            id = id,
            name = name,
            model = model,
            vehicleClass = vehicleClass,
            manufacturer = manufacturer,
            length = length,
            costInCredits = costInCredits,
            crew = crew,
            maxAtmospheringSpeed = maxAtmospheringSpeed,
            cargoCapacity = cargoCapacity,
            consumables = consumables,
            filmIds = filmIds,
            pilotIds = pilotIds,
        )
    }
}
