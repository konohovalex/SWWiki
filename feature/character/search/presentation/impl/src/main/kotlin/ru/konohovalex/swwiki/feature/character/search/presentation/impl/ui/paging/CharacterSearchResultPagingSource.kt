package ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchResultUiModel

class CharacterSearchResultPagingSource(
    private val loadItems: suspend (page: Int) -> List<CharacterSearchResultUiModel>
) : PagingSource<Int, CharacterSearchResultUiModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterSearchResultUiModel> {
        return try {
            val page = params.key ?: 1
            val response = loadItems(page)
            LoadResult.Page(
                data = response,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = if (response.isNotEmpty()) page + 1 else null,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterSearchResultUiModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
