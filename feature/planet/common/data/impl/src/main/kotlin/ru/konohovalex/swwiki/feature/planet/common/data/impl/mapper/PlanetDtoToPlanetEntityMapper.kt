package ru.konohovalex.swwiki.feature.planet.common.data.impl.mapper

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.network.exception.WrongIdFormatException
import ru.konohovalex.swwiki.core.network.extractor.IdFromUrlExtractor
import ru.konohovalex.swwiki.feature.planet.common.data.api.dto.PlanetDto
import ru.konohovalex.swwiki.feature.planet.common.data.api.entity.PlanetEntity
import javax.inject.Inject

internal class PlanetDtoToPlanetEntityMapper
@Inject constructor() : Mapper<PlanetDto, PlanetEntity> {
    override fun invoke(source: PlanetDto): PlanetEntity = with(source) {
        val id = IdFromUrlExtractor.extract(url) ?: throw WrongIdFormatException()
        val residentIds = residentUrls.mapNotNull(IdFromUrlExtractor::extract)
        val filmIds = filmUrls.mapNotNull(IdFromUrlExtractor::extract)
        return PlanetEntity(
            id = id,
            name = name,
            diameter = diameter,
            rotationPeriod = rotationPeriod,
            orbitalPeriod = orbitalPeriod,
            gravity = gravity,
            population = population,
            climate = climate,
            terrain = terrain,
            surfaceWater = surfaceWater,
            residentIds = residentIds,
            filmIds = filmIds,
            editedDate = editedDate.toLocalDateTime(TimeZone.UTC),
        )
    }
}
