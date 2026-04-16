package ru.konohovalex.swwiki.feature.planet.common.domain.api.di

import ru.konohovalex.swwiki.feature.planet.common.domain.api.repository.PlanetRepository

interface IPlanetDomainComponent {
    fun planetRepository(): PlanetRepository
}
