package ru.konohovalex.swwiki.feature.character.search.domain.api.usecase

import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultPagingModel

interface GetAllCharactersUseCase {
    suspend operator fun invoke(page: Int): CharacterSearchResultPagingModel
}
