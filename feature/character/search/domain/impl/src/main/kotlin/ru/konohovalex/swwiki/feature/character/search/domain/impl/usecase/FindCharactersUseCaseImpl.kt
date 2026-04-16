package ru.konohovalex.swwiki.feature.character.search.domain.impl.usecase

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharactersPagingModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultPagingModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.FindCharactersUseCase
import javax.inject.Inject

internal class FindCharactersUseCaseImpl
@Inject constructor(
    private val characterRepository: CharacterRepository,
    private val charactersPagingModelToCharacterSearchResultPagingModelMapper: Mapper<CharactersPagingModel, CharacterSearchResultPagingModel>
) : FindCharactersUseCase {
    override suspend operator fun invoke(
        page: Int,
        query: String,
    ): CharacterSearchResultPagingModel? =
        characterRepository.findCharacters(page, query)?.let {
            charactersPagingModelToCharacterSearchResultPagingModelMapper(it)
        }
}
