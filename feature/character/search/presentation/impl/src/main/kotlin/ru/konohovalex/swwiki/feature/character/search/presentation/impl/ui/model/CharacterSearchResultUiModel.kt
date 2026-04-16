package ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model

import androidx.compose.runtime.Immutable
import ru.konohovalex.swwiki.core.ui.model.GenderUiModel

@Immutable
data class CharacterSearchResultUiModel(
    val id: Int,
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: GenderUiModel,
    val hairColor: String,
    val height: String,
    val mass: String,
    val skinColor: String,
)
