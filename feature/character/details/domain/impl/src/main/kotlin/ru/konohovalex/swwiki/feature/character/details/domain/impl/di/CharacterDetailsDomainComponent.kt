package ru.konohovalex.swwiki.feature.character.details.domain.impl.di

import dagger.Component
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent
import ru.konohovalex.swwiki.feature.character.details.domain.api.di.ICharacterDetailsDomainComponent
import ru.konohovalex.swwiki.feature.film.common.domain.api.IFilmDomainComponent
import ru.konohovalex.swwiki.feature.planet.common.domain.api.di.IPlanetDomainComponent
import ru.konohovalex.swwiki.feature.specie.common.domain.api.di.ISpecieDomainComponent
import ru.konohovalex.swwiki.feature.starship.common.domain.api.di.IStarshipDomainComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di.IVehicleDomainComponent

@Component(
    modules = [
        CharacterDetailsUseCaseModule::class,
        CharacterDetailsDomainMapperModule::class,
    ],
    dependencies = [
        ICharacterDomainComponent::class,
        IFilmDomainComponent::class,
        IPlanetDomainComponent::class,
        ISpecieDomainComponent::class,
        IStarshipDomainComponent::class,
        IVehicleDomainComponent::class,
    ],
)
internal interface CharacterDetailsDomainComponent : ICharacterDetailsDomainComponent {
    @Component.Builder
    interface Builder {
        fun characterDomainComponent(component: ICharacterDomainComponent): Builder

        fun filmDomainComponent(component: IFilmDomainComponent): Builder

        fun planetDomainComponent(component: IPlanetDomainComponent): Builder

        fun specieDomainComponent(component: ISpecieDomainComponent): Builder

        fun starshipDomainComponent(component: IStarshipDomainComponent): Builder

        fun vehicleDomainComponent(component: IVehicleDomainComponent): Builder

        fun build(): CharacterDetailsDomainComponent
    }
}
