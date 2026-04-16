package ru.konohovalex.swwiki.core.cache.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CacheModule::class,
    ],
)
interface CacheComponent {
    fun characterCache(): RuntimeCache<Int, CharacterModel>
    fun filmCache(): RuntimeCache<Int, FilmModel>
    fun planetCache(): RuntimeCache<Int, PlanetModel>
    fun specieCache(): RuntimeCache<Int, SpecieModel>
    fun starshipCache(): RuntimeCache<Int, StarshipModel>
    fun vehicleCache(): RuntimeCache<Int, VehicleModel>
}
