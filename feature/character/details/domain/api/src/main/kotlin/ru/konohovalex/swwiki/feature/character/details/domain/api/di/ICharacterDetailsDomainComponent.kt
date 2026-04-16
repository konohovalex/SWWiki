package ru.konohovalex.swwiki.feature.character.details.domain.api.di

import ru.konohovalex.swwiki.feature.character.details.domain.api.usecase.GetCharacterDetailsUseCase

interface ICharacterDetailsDomainComponent {
    fun getCharacterDetailsUseCase(): GetCharacterDetailsUseCase
}
