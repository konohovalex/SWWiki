package ru.konohovalex.swwiki.feature.main.impl.presentation.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed interface MainUiState {
    data class Topics(val topics: ImmutableList<TopicUiModel>) : MainUiState

    data object Error : MainUiState
}
