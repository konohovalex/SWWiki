package ru.konohovalex.swwiki.feature.planet.common.domain.api.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.planet.common.domain.api.repository.PlanetRepository

interface IPlanetDomainComponent : IComponent {
    fun planetRepository(): PlanetRepository
}
