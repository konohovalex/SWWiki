package ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.mapper

import kotlinx.collections.immutable.toPersistentList
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.ui.model.GenderUiModel
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model.CharacterDetailsUiModel
import javax.inject.Inject

internal class CharacterDetailsModelToCharacterDetailsUiModelMapper
@Inject constructor() : Mapper<CharacterDetailsModel, CharacterDetailsUiModel> {
    override operator fun invoke(source: CharacterDetailsModel): CharacterDetailsUiModel =
        with(source) {
            CharacterDetailsUiModel(
                basicInformation = with(source.basicInformation) {
                    CharacterDetailsUiModel.BasicInformation(
                        name = name,
                        birthYear = birthYear,
                        eyeColor = eyeColor,
                        gender = GenderUiModel.from(gender),
                        hairColor = hairColor,
                        height = height,
                        mass = mass,
                        skinColor = skinColor,
                        homeworld = homeworld ?: "",
                    )
                },
                films = films.map {
                    CharacterDetailsUiModel.Film(
                        title = it.title,
                        openingCrawl = it.openingCrawl,
                    )
                }.toPersistentList(),
                species = species.map {
                    CharacterDetailsUiModel.Specie(
                        name = it.name,
                    )
                }.toPersistentList(),
                starships = starships.map {
                    CharacterDetailsUiModel.Starship(
                        name = it.name,
                        model = it.model,
                    )
                }.toPersistentList(),
                vehicles = vehicles.map {
                    CharacterDetailsUiModel.Vehicle(
                        name = it.name,
                        model = it.model,
                    )
                }.toPersistentList(),
            )
        }
}
