package ru.konohovalex.swwiki.feature.starship.common.domain.api.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.starship.common.domain.api.repository.StarshipRepository

interface IStarshipDomainComponent : IComponent {
    fun starshipRepository(): StarshipRepository
}
