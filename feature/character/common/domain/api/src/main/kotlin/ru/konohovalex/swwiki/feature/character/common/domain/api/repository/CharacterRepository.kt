package ru.konohovalex.swwiki.feature.character.common.domain.api.repository

import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharactersPagingModel

interface CharacterRepository {
    suspend fun getAllCharacters(page: Int): CharactersPagingModel?

    suspend fun getCharacter(id: Int): CharacterModel?

    suspend fun findCharacters(page: Int, query: String): CharactersPagingModel?
}
