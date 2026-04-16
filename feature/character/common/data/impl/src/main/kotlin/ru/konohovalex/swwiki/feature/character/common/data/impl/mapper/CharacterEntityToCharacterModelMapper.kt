package ru.konohovalex.swwiki.feature.character.common.data.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.data.api.entity.CharacterEntity
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import javax.inject.Inject

internal class CharacterEntityToCharacterModelMapper
@Inject constructor() : Mapper<CharacterEntity, CharacterModel> {
    override fun invoke(source: CharacterEntity): CharacterModel = with(source) {
        CharacterModel(
            id = id,
            name = name,
            birthYear = birthYear,
            eyeColor = eyeColor,
            gender = gender,
            hairColor = hairColor,
            height = height,
            mass = mass,
            skinColor = skinColor,
            homeworldId = homeworldId,
            filmIds = filmIds,
            specieIds = specieIds,
            starshipIds = starshipIds,
            vehicleIds = vehicleIds,
        )
    }
}
