package ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import javax.inject.Inject

class StarshipModelToCharacterDetailsStarshipMapper
@Inject constructor() : Mapper<StarshipModel, CharacterDetailsModel.Starship> {
    override fun invoke(source: StarshipModel): CharacterDetailsModel.Starship = with(source) {
        CharacterDetailsModel.Starship(
            id = id,
            name = name,
            model = model,
        )
    }
}
