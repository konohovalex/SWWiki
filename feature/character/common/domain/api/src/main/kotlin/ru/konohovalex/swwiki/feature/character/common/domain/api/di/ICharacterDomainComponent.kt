package ru.konohovalex.swwiki.feature.character.common.domain.api.di

import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository

interface ICharacterDomainComponent {
    fun characterRepository(): CharacterRepository
}
