package ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import javax.inject.Inject

class FilmModelToCharacterDetailsFilmMapper
@Inject constructor() : Mapper<FilmModel, CharacterDetailsModel.Film> {
    override fun invoke(source: FilmModel): CharacterDetailsModel.Film = with(source) {
        CharacterDetailsModel.Film(
            id = id,
            title = title,
            openingCrawl = openingCrawl,
        )
    }
}
