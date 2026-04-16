package ru.konohovalex.swwiki.feature.character.search.domain.api.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.FindCharactersUseCase
import ru.konohovalex.swwiki.feature.character.search.domain.api.usecase.GetAllCharactersUseCase

interface ICharacterSearchDomainComponent : IComponent {
    fun getAllCharactersUseCase(): GetAllCharactersUseCase
    fun findCharactersUseCase(): FindCharactersUseCase
}
