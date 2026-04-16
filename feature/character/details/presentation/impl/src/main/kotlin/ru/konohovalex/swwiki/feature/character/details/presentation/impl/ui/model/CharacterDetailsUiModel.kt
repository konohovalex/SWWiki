package ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import ru.konohovalex.swwiki.core.ui.model.GenderUiModel

@Immutable
data class CharacterDetailsUiModel(
    val basicInformation: BasicInformation,
    val films: ImmutableList<Film>,
    val species: ImmutableList<Specie>,
    val starships: ImmutableList<Starship>,
    val vehicles: ImmutableList<Vehicle>,
) {
    @Immutable
    data class BasicInformation(
        val name: String,
        val birthYear: String,
        val eyeColor: String,
        val gender: GenderUiModel,
        val hairColor: String,
        val height: Int,
        val mass: Int,
        val skinColor: String,
        val homeworld: String?,
    )

    @Immutable
    data class Film(
        val title: String,
        val openingCrawl: String,
    )

    @Immutable
    data class Specie(
        val name: String,
    )

    @Immutable
    data class Starship(
        val name: String,
        val model: String,
    )

    @Immutable
    data class Vehicle(
        val name: String,
        val model: String,
    )
}
