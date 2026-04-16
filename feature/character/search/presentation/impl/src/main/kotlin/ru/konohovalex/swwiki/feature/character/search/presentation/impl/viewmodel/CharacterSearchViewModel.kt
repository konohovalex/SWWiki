@file:OptIn(ExperimentalAtomicApi::class)

package ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import ru.konohovalex.swwiki.core.di.qualifier.Io
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.FindCharactersUseCase
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.GetAllCharactersUseCase
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchResultUiModel
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchUiState
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.paging.CharacterSearchResultPagingSource
import javax.inject.Inject
import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.ExperimentalAtomicApi

@OptIn(FlowPreview::class)
class CharacterSearchViewModel
@Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val findCharactersUseCase: FindCharactersUseCase,
    private val characterDetailsModelToCharacterDetailsUiModelMapper: Mapper<CharacterSearchResultModel, CharacterSearchResultUiModel>,
    @param:Io
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private companion object {
        private const val SEARCH_DEBOUNCE_TIMEOUT_MILLIS = 1000L
    }

    private val hasNextPage = AtomicBoolean(true)

    private val queryFlow = MutableStateFlow("")

    val uiState: StateFlow<CharacterSearchUiState>
        field = MutableStateFlow(getInitialState())

    fun search(query: String) {
        viewModelScope.launch {
            queryFlow.emit(query)
        }
    }

    fun retry() {

    }

    private fun getInitialState() =
        CharacterSearchUiState(
            pagingData = getPagingData(),
            result = CharacterSearchUiState.Result.LOADING_NEXT,
        )

    private fun getPagingData() =
        queryFlow.debounce(SEARCH_DEBOUNCE_TIMEOUT_MILLIS)
            .flatMapLatest { query ->
                Pager(
                    config = PagingConfig(pageSize = 20, enablePlaceholders = false),
                    pagingSourceFactory = {
                        if (query.isBlank()) {
                            CharacterSearchResultPagingSource { page ->
                                if (hasNextPage.load()) {
                                    getAllCharactersUseCase.invoke(page)?.results
                                        ?.map {
                                            characterDetailsModelToCharacterDetailsUiModelMapper(
                                                it
                                            )
                                        }
                                        ?: emptyList()
                                } else {
                                    emptyList()
                                }
                            }
                        } else {
                            CharacterSearchResultPagingSource { page ->
                                if (hasNextPage.load()) {
                                    findCharactersUseCase.invoke(page, query)?.results
                                        ?.map {
                                            characterDetailsModelToCharacterDetailsUiModelMapper(
                                                it
                                            )
                                        }
                                        ?: emptyList()
                                } else {
                                    emptyList()
                                }
                            }
                        }
                    }
                ).flow.cachedIn(viewModelScope)
            }
}
