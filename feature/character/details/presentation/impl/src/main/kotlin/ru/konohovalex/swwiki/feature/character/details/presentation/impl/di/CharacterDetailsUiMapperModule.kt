package ru.konohovalex.swwiki.feature.character.details.presentation.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model.CharacterDetailsUiModel
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.mapper.CharacterDetailsModelToCharacterDetailsUiModelMapper

@Module
internal interface CharacterDetailsUiMapperModule {
    @Binds
    fun bindCharacterDetailsModelToCharacterDetailsUiModelMapper(
        impl: CharacterDetailsModelToCharacterDetailsUiModelMapper
    ): Mapper<CharacterDetailsModel, CharacterDetailsUiModel>
}
