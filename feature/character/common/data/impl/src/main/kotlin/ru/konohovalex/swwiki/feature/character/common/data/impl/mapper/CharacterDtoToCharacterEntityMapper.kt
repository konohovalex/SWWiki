package ru.konohovalex.swwiki.feature.character.common.data.impl.mapper

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.network.exception.WrongIdFormatException
import ru.konohovalex.swwiki.core.network.extractor.IdFromUrlExtractor
import ru.konohovalex.swwiki.feature.character.common.data.api.dto.CharacterDto
import ru.konohovalex.swwiki.feature.character.common.data.api.entity.CharacterEntity
import javax.inject.Inject

internal class CharacterDtoToCharacterEntityMapper
@Inject constructor() : Mapper<CharacterDto, CharacterEntity> {
    override fun invoke(source: CharacterDto): CharacterEntity = with(source) {
        val id = IdFromUrlExtractor.extract(url) ?: throw WrongIdFormatException()
        val homeworldId = homeworldUrl?.let(IdFromUrlExtractor::extract)
        val filmIds = filmUrls.mapNotNull(IdFromUrlExtractor::extract)
        val specieIds = specieUrls.mapNotNull(IdFromUrlExtractor::extract)
        val starshipIds = starshipUrls.mapNotNull(IdFromUrlExtractor::extract)
        val vehicleIds = vehicleUrls.mapNotNull(IdFromUrlExtractor::extract)
        return CharacterEntity(
            id = id,
            name = name,
            birthYear = birthYear,
            eyeColor = eyeColor,
            gender = gender.ordinal,
            hairColor = hairColor,
            height = height,
            mass = mass,
            skinColor = skinColor,
            homeworldId = homeworldId,
            filmIds = filmIds,
            specieIds = specieIds,
            starshipIds = starshipIds,
            vehicleIds = vehicleIds,
            editedDate = editedDate.toLocalDateTime(TimeZone.UTC),
        )
    }
}
