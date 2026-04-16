package ru.konohovalex.swwiki.core.database.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.character.common.data.api.database.CharacterDao
import ru.konohovalex.swwiki.feature.film.common.data.api.database.FilmDao
import ru.konohovalex.swwiki.feature.planet.common.data.api.database.PlanetDao
import ru.konohovalex.swwiki.feature.specie.common.data.api.database.SpecieDao
import ru.konohovalex.swwiki.feature.starship.common.data.api.database.StarshipDao
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.database.VehicleDao

interface IDatabaseComponent : IComponent {
    fun characterDao(): CharacterDao
    fun filmDao(): FilmDao
    fun planetDao(): PlanetDao
    fun specieDao(): SpecieDao
    fun starshipDao(): StarshipDao
    fun vehicleDao(): VehicleDao
}
