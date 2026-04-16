package ru.konohovalex.swwiki.feature.film.common.data.impl.mapper

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.network.exception.WrongIdFormatException
import ru.konohovalex.swwiki.core.network.extractor.IdFromUrlExtractor
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto.VehicleDto
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity.VehicleEntity
import javax.inject.Inject

internal class VehicleDtoToVehicleEntityMapper
@Inject constructor() : Mapper<VehicleDto, VehicleEntity> {
    override fun invoke(source: VehicleDto): VehicleEntity = with(source) {
        val id = IdFromUrlExtractor.extract(url) ?: throw WrongIdFormatException()
        val filmIds = filmUrls.mapNotNull(IdFromUrlExtractor::extract)
        val pilotIds = pilotUrls.mapNotNull(IdFromUrlExtractor::extract)
        return VehicleEntity(
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
            editedDate = editedDate.toLocalDateTime(TimeZone.UTC),
        )
    }
}
