package ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.FindCharactersUseCase
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.GetAllCharactersUseCase
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchResultUiModel
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.paging.CharacterSearchResultPagingSource
import javax.inject.Inject
import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.ExperimentalAtomicApi

@OptIn(ExperimentalAtomicApi::class, FlowPreview::class)
class CharacterSearchViewModel
@Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val findCharactersUseCase: FindCharactersUseCase,
    private val characterDetailsModelToCharacterDetailsUiModelMapper: Mapper<CharacterSearchResultModel, CharacterSearchResultUiModel>,
) : ViewModel() {
    private companion object {
        private const val PAGE_SIZE = 10
        private const val SEARCH_DEBOUNCE_TIMEOUT_MILLIS = 750L
    }

    private val hasNextPage =
        AtomicBoolean(true)

    private val shouldRecreateQueryPager =
        AtomicBoolean(true)
    private val queryPager =
        AtomicReference<Flow<PagingData<CharacterSearchResultUiModel>>?>(null)

    private val pagingConfig = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false)

    private val allCharactersPagingData: Flow<PagingData<CharacterSearchResultUiModel>> =
        Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                CharacterSearchResultPagingSource { page ->
                    if (hasNextPage.load()) {
                        getAllCharactersUseCase.invoke(page)
                            .also {
                                if (it.next == null) {
                                    hasNextPage.store(false)
                                }
                            }
                            .results
                            .map(characterDetailsModelToCharacterDetailsUiModelMapper::invoke)
                    } else {
                        emptyList()
                    }
                }
            }
        ).flow.cachedIn(viewModelScope)

    private val queryFlow = MutableStateFlow("")

    private val searchCharactersPagingData: Flow<PagingData<CharacterSearchResultUiModel>> =
        queryFlow
            .debounce(SEARCH_DEBOUNCE_TIMEOUT_MILLIS)
            .flatMapLatest { query ->
                if (shouldRecreateQueryPager.load()) {
                    createQueryPager(query)
                } else {
                    queryPager.load() ?: throw IllegalStateException("Impossible")
                }
            }

    val pagingData: Flow<PagingData<CharacterSearchResultUiModel>> =
        queryFlow
            .map { query -> query.isBlank() }
            .distinctUntilChanged()
            .onEach { hasNextPage.store(true) }
            .flatMapLatest { isBlank ->
                if (isBlank) {
                    allCharactersPagingData
                } else {
                    searchCharactersPagingData
                }
            }

    fun search(query: String) {
        viewModelScope.launch {
            queryFlow.emit(query)
        }
    }

    // TODO(skywalker -> sky -> seems to be completed)
    private fun createQueryPager(query: String) = Pager(
        config = pagingConfig,
        pagingSourceFactory = {
            CharacterSearchResultPagingSource { page ->
                if (hasNextPage.load()) {
                    findCharactersUseCase.invoke(page, query)
                        .also {
                            if (it.next == null) {
                                hasNextPage.store(false)
                                shouldRecreateQueryPager.store(true)
                            }
                        }
                        .results
                        .map(characterDetailsModelToCharacterDetailsUiModelMapper::invoke)
                } else {
                    emptyList()
                }
            }
        }
    ).flow.cachedIn(viewModelScope).also {
        queryPager.load()
    }
}
