package ru.konohovalex.swwiki.feature.character.common.data.impl.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.data.api.database.CharacterDao
import ru.konohovalex.swwiki.feature.character.common.data.api.dto.CharacterDto
import ru.konohovalex.swwiki.feature.character.common.data.api.entity.CharacterEntity
import ru.konohovalex.swwiki.feature.character.common.data.api.network.CharacterApi
import ru.konohovalex.swwiki.feature.character.common.data.impl.repository.CharacterRepositoryImpl
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository

@Module
internal class CharacterRepositoryModule {
    @Provides
    fun provideCharacterRepository(
        characterCache: RuntimeCache<Int, CharacterModel>,
        characterApi: CharacterApi,
        characterDao: CharacterDao,
        dtoToEntityMapper: Mapper<CharacterDto, CharacterEntity>,
        entityToModelMapper: Mapper<CharacterEntity, CharacterModel>,
    ): CharacterRepository = CharacterRepositoryImpl(
        characterCache,
        characterApi,
        characterDao,
        dtoToEntityMapper,
        entityToModelMapper,
    )
}
