package ru.konohovalex.swwiki.feature.character.search.domain.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharactersPagingModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultPagingModel
import javax.inject.Inject

class CharactersPagingModelToCharacterSearchResultPagingModelMapper
@Inject constructor() : Mapper<CharactersPagingModel, CharacterSearchResultPagingModel> {
    override fun invoke(source: CharactersPagingModel): CharacterSearchResultPagingModel =
        with(source) {
            CharacterSearchResultPagingModel(
                next = next,
                results = results.map
                { character ->
                    with(character) {
                        CharacterSearchResultModel(
                            id = id,
                            name = name,
                            birthYear = birthYear,
                            eyeColor = eyeColor,
                            gender = gender,
                            hairColor = hairColor,
                            height = height,
                            mass = mass,
                            skinColor = skinColor,
                        )
                    }
                }
            )
        }
}
