package ru.konohovalex.swwiki.feature.character.search.domain.impl.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharactersPagingModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultPagingModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.FindCharactersUseCase
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.GetAllCharactersUseCase
import ru.konohovalex.swwiki.feature.character.search.domain.impl.usecase.FindCharactersUseCaseImpl
import ru.konohovalex.swwiki.feature.character.search.domain.impl.usecase.GetAllCharactersUseCaseImpl

@Module
internal class CharacterSearchUseCaseModule {
    @Provides
    fun bindGetAllCharactersUseCase(
        characterRepository: CharacterRepository,
        charactersPagingModelToCharacterSearchResultPagingModelMapper: Mapper<CharactersPagingModel, CharacterSearchResultPagingModel>,
    ): GetAllCharactersUseCase = GetAllCharactersUseCaseImpl(
        characterRepository,
        charactersPagingModelToCharacterSearchResultPagingModelMapper,
    )

    @Provides
    fun bindFindCharactersUseCaseImpl(
        characterRepository: CharacterRepository,
        charactersPagingModelToCharacterSearchResultPagingModelMapper: Mapper<CharactersPagingModel, CharacterSearchResultPagingModel>,
    ): FindCharactersUseCase = FindCharactersUseCaseImpl(
        characterRepository,
        charactersPagingModelToCharacterSearchResultPagingModelMapper,
    )
}
