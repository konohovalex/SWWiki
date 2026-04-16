package ru.konohovalex.swwiki.feature.character.details.domain.api.usecase

import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel

interface GetCharacterDetailsUseCase {
    suspend operator fun invoke(id: Int): CharacterDetailsModel?
}
