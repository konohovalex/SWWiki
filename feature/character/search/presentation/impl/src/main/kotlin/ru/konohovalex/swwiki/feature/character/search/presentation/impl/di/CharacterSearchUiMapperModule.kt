package ru.konohovalex.swwiki.feature.character.search.presentation.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.search.domain.api.model.CharacterSearchResultModel
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.mapper.CharacterSearchResultModelToCharacterSearchResultUiModelMapper
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchResultUiModel

@Module
internal interface CharacterSearchUiMapperModule {
    @Binds
    fun bindCharacterSearchResultModelToCharacterSearchResultUiModelMapper(
        impl: CharacterSearchResultModelToCharacterSearchResultUiModelMapper
    ): Mapper<CharacterSearchResultModel, CharacterSearchResultUiModel>
}
