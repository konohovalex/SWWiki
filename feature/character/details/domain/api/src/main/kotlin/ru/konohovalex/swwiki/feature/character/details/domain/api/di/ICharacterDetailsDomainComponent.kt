package ru.konohovalex.swwiki.feature.character.details.domain.api.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.character.details.domain.api.usecase.GetCharacterDetailsUseCase

interface ICharacterDetailsDomainComponent : IComponent {
    fun getCharacterDetailsUseCase(): GetCharacterDetailsUseCase
}
