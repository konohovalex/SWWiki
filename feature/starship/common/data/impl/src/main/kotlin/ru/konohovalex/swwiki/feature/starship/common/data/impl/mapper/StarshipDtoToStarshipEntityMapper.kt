package ru.konohovalex.swwiki.feature.starship.common.data.impl.mapper

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.network.exception.WrongIdFormatException
import ru.konohovalex.swwiki.core.network.extractor.IdFromUrlExtractor
import ru.konohovalex.swwiki.feature.starship.common.data.api.dto.StarshipDto
import ru.konohovalex.swwiki.feature.starship.common.data.api.entity.StarshipEntity
import javax.inject.Inject

internal class StarshipDtoToStarshipEntityMapper
@Inject constructor() : Mapper<StarshipDto, StarshipEntity> {
    override fun invoke(source: StarshipDto): StarshipEntity = with(source) {
        val id = IdFromUrlExtractor.extract(url) ?: throw WrongIdFormatException()
        val filmIds = filmUrls.mapNotNull(IdFromUrlExtractor::extract)
        val pilotIds = pilotUrls.mapNotNull(IdFromUrlExtractor::extract)
        return StarshipEntity(
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
            editedDate = editedDate.toLocalDateTime(TimeZone.UTC),
        )
    }
}
