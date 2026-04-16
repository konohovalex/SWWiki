package ru.konohovalex.swwiki.feature.character.details.domain.impl.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent
import ru.konohovalex.swwiki.feature.character.details.domain.api.di.ICharacterDetailsDomainComponent
import ru.konohovalex.swwiki.feature.character.details.domain.impl.di.DaggerCharacterDetailsDomainComponent
import ru.konohovalex.swwiki.feature.film.common.domain.api.IFilmDomainComponent
import ru.konohovalex.swwiki.feature.planet.common.domain.api.di.IPlanetDomainComponent
import ru.konohovalex.swwiki.feature.specie.common.domain.api.di.ISpecieDomainComponent
import ru.konohovalex.swwiki.feature.starship.common.domain.api.di.IStarshipDomainComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di.IVehicleDomainComponent

class CharacterDetailsDomainComponentInitializer(
    private val characterDomainComponent: ICharacterDomainComponent,
    private val filmDomainComponent: IFilmDomainComponent,
    private val planetDomainComponent: IPlanetDomainComponent,
    private val specieDomainComponent: ISpecieDomainComponent,
    private val starshipDomainComponent: IStarshipDomainComponent,
    private val vehicleDomainComponent: IVehicleDomainComponent,
) : ComponentInitializer<ICharacterDetailsDomainComponent> {
    override fun initialize(): ICharacterDetailsDomainComponent {
        return DaggerCharacterDetailsDomainComponent.builder()
            .characterDomainComponent(characterDomainComponent)
            .filmDomainComponent(filmDomainComponent)
            .planetDomainComponent(planetDomainComponent)
            .specieDomainComponent(specieDomainComponent)
            .starshipDomainComponent(starshipDomainComponent)
            .vehicleDomainComponent(vehicleDomainComponent)
            .build()
    }
}
