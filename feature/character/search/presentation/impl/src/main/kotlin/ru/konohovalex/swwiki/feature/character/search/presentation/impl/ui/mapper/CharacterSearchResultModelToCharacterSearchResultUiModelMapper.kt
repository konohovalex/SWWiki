package ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.ui.model.GenderUiModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultModel
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchResultUiModel
import javax.inject.Inject

internal class CharacterSearchResultModelToCharacterSearchResultUiModelMapper
@Inject constructor() : Mapper<CharacterSearchResultModel, CharacterSearchResultUiModel> {
    override operator fun invoke(source: CharacterSearchResultModel): CharacterSearchResultUiModel =
        with(source) {
            CharacterSearchResultUiModel(
                id = id,
                name = name,
                birthYear = birthYear,
                eyeColor = eyeColor,
                gender = GenderUiModel.from(gender),
                hairColor = hairColor,
                height = height,
                mass = mass,
                skinColor = skinColor,
            )
        }
}
