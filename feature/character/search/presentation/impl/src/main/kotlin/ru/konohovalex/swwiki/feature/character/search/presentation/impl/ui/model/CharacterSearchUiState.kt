package ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model

import androidx.compose.runtime.Immutable
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

@Immutable
data class CharacterSearchUiState(
    val pagingData: Flow<PagingData<CharacterSearchResultUiModel>>,
    val result: Result,
) {
    enum class Result {
        SUCCESS,
        LOADING_NEXT,
        ERROR,
    }
}
