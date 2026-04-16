package ru.konohovalex.swwiki.feature.film.common.data.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.film.common.data.api.entity.FilmEntity
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import javax.inject.Inject

internal class FilmEntityToFilmModelMapper
@Inject constructor() : Mapper<FilmEntity, FilmModel> {
    override fun invoke(source: FilmEntity): FilmModel = with(source) {
        FilmModel(
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
        )
    }
}
