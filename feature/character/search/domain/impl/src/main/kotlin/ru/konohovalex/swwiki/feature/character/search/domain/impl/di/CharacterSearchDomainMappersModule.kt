package ru.konohovalex.swwiki.feature.character.search.domain.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharactersPagingModel
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultPagingModel
import ru.konohovalex.swwiki.feature.character.search.domain.impl.mapper.CharactersPagingModelToCharacterSearchResultPagingModelMapper

@Module
internal interface CharacterSearchDomainMappersModule {
    @Binds
    fun bindCharactersPagingModelToCharacterSearchResultPagingModelMapper(
        impl: CharactersPagingModelToCharacterSearchResultPagingModelMapper
    ): Mapper<CharactersPagingModel, CharacterSearchResultPagingModel>
}
