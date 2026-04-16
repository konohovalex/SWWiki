package ru.konohovalex.swwiki.feature.character.common.data.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.data.api.dto.CharacterDto
import ru.konohovalex.swwiki.feature.character.common.data.api.entity.CharacterEntity
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.common.data.impl.mapper.CharacterDtoToCharacterEntityMapper
import ru.konohovalex.swwiki.feature.character.common.data.impl.mapper.CharacterEntityToCharacterModelMapper

@Module
internal interface CharacterDomainMapperModule {
    @Binds
    fun bindCharacterDtoToCharacterEntityMapper(
        impl: CharacterDtoToCharacterEntityMapper
    ): Mapper<CharacterDto, CharacterEntity>

    @Binds
    fun bindCharacterEntityToCharacterModelMapper(
        impl: CharacterEntityToCharacterModelMapper
    ): Mapper<CharacterEntity, CharacterModel>
}
