package ru.konohovalex.swwiki.feature.specie.common.data.impl.mapper

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.network.exception.WrongIdFormatException
import ru.konohovalex.swwiki.core.network.extractor.IdFromUrlExtractor
import ru.konohovalex.swwiki.feature.specie.common.data.api.dto.SpecieDto
import ru.konohovalex.swwiki.feature.specie.common.data.api.entity.SpecieEntity
import javax.inject.Inject

internal class SpecieDtoToSpecieEntityMapper
@Inject constructor() : Mapper<SpecieDto, SpecieEntity> {
    override fun invoke(source: SpecieDto): SpecieEntity = with(source) {
        val id = IdFromUrlExtractor.extract(url) ?: throw WrongIdFormatException()
        val homeworldId = homeworldUrl?.let(IdFromUrlExtractor::extract)
        val characterId = characterUrls.mapNotNull(IdFromUrlExtractor::extract)
        val filmIds = filmUrls.mapNotNull(IdFromUrlExtractor::extract)
        return SpecieEntity(
            id = id,
            name = name,
            classification = classification,
            designation = designation,
            averageHeight = averageHeight,
            averageLifespan = averageLifespan,
            eyeColors = eyeColors,
            hairColors = hairColors,
            skinColors = skinColors,
            language = language,
            homeworldId = homeworldId,
            characterId = characterId,
            filmIds = filmIds,
            editedDate = editedDate.toLocalDateTime(TimeZone.UTC),
        )
    }
}
