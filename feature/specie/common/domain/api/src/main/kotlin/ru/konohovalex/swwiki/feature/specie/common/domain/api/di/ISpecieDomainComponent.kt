package ru.konohovalex.swwiki.feature.specie.common.domain.api.di

import ru.konohovalex.swwiki.feature.specie.common.domain.api.repository.SpecieRepository

interface ISpecieDomainComponent {
    fun specieRepository(): SpecieRepository
}
