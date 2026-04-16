package ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper2
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import javax.inject.Inject

class CharacterModelToCharacterDetailsBasicInformationMapper
@Inject constructor() :
    Mapper2<CharacterModel, PlanetModel?, CharacterDetailsModel.BasicInformation> {
    override fun invoke(
        source1: CharacterModel,
        source2: PlanetModel?,
    ): CharacterDetailsModel.BasicInformation =
        with(source1) {
            CharacterDetailsModel.BasicInformation(
                name = name,
                birthYear = birthYear,
                eyeColor = eyeColor,
                gender = gender,
                hairColor = hairColor,
                height = height,
                mass = mass,
                skinColor = skinColor,
                homeworld = source2?.name,
            )
        }
}
