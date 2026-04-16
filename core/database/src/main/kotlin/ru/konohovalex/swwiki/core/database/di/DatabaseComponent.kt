package ru.konohovalex.swwiki.core.database.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.konohovalex.swwiki.core.di.qualifier.ApplicationContext
import ru.konohovalex.swwiki.feature.character.common.data.api.database.CharacterDao
import ru.konohovalex.swwiki.feature.film.common.data.api.database.FilmDao
import ru.konohovalex.swwiki.feature.planet.common.data.api.database.PlanetDao
import ru.konohovalex.swwiki.feature.specie.common.data.api.database.SpecieDao
import ru.konohovalex.swwiki.feature.starship.common.data.api.database.StarshipDao
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.database.VehicleDao
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
    ]
)
interface DatabaseComponent {
    fun characterDao(): CharacterDao
    fun filmDao(): FilmDao
    fun planetDao(): PlanetDao
    fun specieDao(): SpecieDao
    fun starshipDao(): StarshipDao
    fun vehicleDao(): VehicleDao

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder

        fun build(): DatabaseComponent
    }
}
