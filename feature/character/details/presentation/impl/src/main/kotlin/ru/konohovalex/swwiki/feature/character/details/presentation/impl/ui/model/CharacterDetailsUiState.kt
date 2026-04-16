package ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model

import androidx.compose.runtime.Immutable

@Immutable
sealed interface CharacterDetailsUiState {
    data class Loading(val characterName: String) : CharacterDetailsUiState

    data class Data(val model: CharacterDetailsUiModel) : CharacterDetailsUiState

    data class Error(val characterName: String) : CharacterDetailsUiState
}
