package ru.konohovalex.swwiki.feature.planet.common.data.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.planet.common.data.api.entity.PlanetEntity
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import javax.inject.Inject

internal class PlanetEntityToPlanetModelMapper
@Inject constructor() : Mapper<PlanetEntity, PlanetModel> {
    override fun invoke(source: PlanetEntity): PlanetModel = with(source) {
        PlanetModel(
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
        )
    }
}
