package ru.konohovalex.swwiki.feature.film.common.data.impl.mapper

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.network.exception.WrongIdFormatException
import ru.konohovalex.swwiki.core.network.extractor.IdFromUrlExtractor
import ru.konohovalex.swwiki.feature.film.common.data.api.dto.FilmDto
import ru.konohovalex.swwiki.feature.film.common.data.api.entity.FilmEntity
import javax.inject.Inject

internal class FilmDtoToFilmEntityMapper
@Inject constructor() : Mapper<FilmDto, FilmEntity> {
    override fun invoke(source: FilmDto): FilmEntity = with(source) {
        val id = IdFromUrlExtractor.extract(url) ?: throw WrongIdFormatException()
        val specieIds = specieUrls.mapNotNull(IdFromUrlExtractor::extract)
        val starshipIds = starshipUrls.mapNotNull(IdFromUrlExtractor::extract)
        val vehicleIds = vehicleUrls.mapNotNull(IdFromUrlExtractor::extract)
        val characterIds = characterUrls.mapNotNull(IdFromUrlExtractor::extract)
        val planetIds = planetUrls.mapNotNull(IdFromUrlExtractor::extract)
        return FilmEntity(
            id = id,
            title = title,
            openingCrawl = openingCrawl,
            director = director,
            producer = producer,
            releaseDate = releaseDate,
            specieIds = specieIds,
            starshipIds = starshipIds,
            vehicleIds = vehicleIds,
            characterIds = characterIds,
            planetIds = planetIds,
            editedDate = editedDate.toLocalDateTime(TimeZone.UTC),
        )
    }
}
