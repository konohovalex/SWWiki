package ru.konohovalex.swwiki.feature.starship.common.data.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.starship.common.data.api.entity.StarshipEntity
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import javax.inject.Inject

internal class StarshipEntityToStarshipModelMapper
@Inject constructor() : Mapper<StarshipEntity, StarshipModel> {
    override fun invoke(source: StarshipEntity): StarshipModel = with(source) {
        StarshipModel(
            id = id,
            name = name,
            model = model,
            starshipClass = starshipClass,
            manufacturer = manufacturer,
            costInCredits = costInCredits,
            length = length,
            crew = crew,
            passengers = passengers,
            maxAtmospheringSpeed = maxAtmospheringSpeed,
            hyperdriveRating = hyperdriveRating,
            mglt = mglt,
            cargoCapacity = cargoCapacity,
            consumables = consumables,
            filmIds = filmIds,
            pilotIds = pilotIds,
        )
    }
}
