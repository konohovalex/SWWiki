package ru.konohovalex.swwiki.feature.specie.common.domain.api.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.specie.common.domain.api.repository.SpecieRepository

interface ISpecieDomainComponent : IComponent {
    fun specieRepository(): SpecieRepository
}
