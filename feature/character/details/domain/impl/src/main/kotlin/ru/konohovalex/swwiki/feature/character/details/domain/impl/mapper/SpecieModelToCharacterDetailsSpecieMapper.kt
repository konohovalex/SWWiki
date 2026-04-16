package ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import javax.inject.Inject

class SpecieModelToCharacterDetailsSpecieMapper
@Inject constructor()  : Mapper<SpecieModel, CharacterDetailsModel.Specie> {
    override fun invoke(source: SpecieModel): CharacterDetailsModel.Specie = with(source) {
        CharacterDetailsModel.Specie(
            id = id,
            name = name,
        )
    }
}
