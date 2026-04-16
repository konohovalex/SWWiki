package ru.konohovalex.swwiki.core.network.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.character.common.data.api.network.CharacterApi
import ru.konohovalex.swwiki.feature.film.common.data.api.network.FilmApi
import ru.konohovalex.swwiki.feature.planet.common.data.api.network.PlanetApi
import ru.konohovalex.swwiki.feature.specie.common.data.api.network.SpecieApi
import ru.konohovalex.swwiki.feature.starship.common.data.api.network.StarshipApi
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.network.VehicleApi

interface INetworkComponent : IComponent {
    fun characterApi(): CharacterApi
    fun filmApi(): FilmApi
    fun planetApi(): PlanetApi
    fun specieApi(): SpecieApi
    fun starshipApi(): StarshipApi
    fun vehicleApi(): VehicleApi
}
