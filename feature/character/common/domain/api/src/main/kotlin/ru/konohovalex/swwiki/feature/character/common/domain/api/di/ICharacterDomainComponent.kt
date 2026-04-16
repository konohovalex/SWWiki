package ru.konohovalex.swwiki.feature.character.common.domain.api.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository

interface ICharacterDomainComponent : IComponent {
    fun characterRepository(): CharacterRepository
}
