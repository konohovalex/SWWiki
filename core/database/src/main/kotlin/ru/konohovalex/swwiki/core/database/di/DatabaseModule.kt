package ru.konohovalex.swwiki.core.database.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.database.SWWikiDatabase
import ru.konohovalex.swwiki.core.database.SWWikiDatabaseBuilder
import ru.konohovalex.swwiki.core.di.qualifier.ApplicationContext
import ru.konohovalex.swwiki.feature.character.common.data.api.database.CharacterDao
import ru.konohovalex.swwiki.feature.film.common.data.api.database.FilmDao
import ru.konohovalex.swwiki.feature.planet.common.data.api.database.PlanetDao
import ru.konohovalex.swwiki.feature.specie.common.data.api.database.SpecieDao
import ru.konohovalex.swwiki.feature.starship.common.data.api.database.StarshipDao
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.database.VehicleDao
import javax.inject.Singleton

@Module
internal class DatabaseModule {
    @[Provides Singleton]
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): SWWikiDatabase = SWWikiDatabaseBuilder().build(context)

    @Provides
    fun provideCharacterDao(sWWikiDatabase: SWWikiDatabase): CharacterDao =
        sWWikiDatabase.characterDao()

    @Provides
    fun provideFilmDao(sWWikiDatabase: SWWikiDatabase): FilmDao =
        sWWikiDatabase.filmDao()

    @Provides
    fun providePlanetDao(sWWikiDatabase: SWWikiDatabase): PlanetDao =
        sWWikiDatabase.planetDao()

    @Provides
    fun provideSpecieDao(sWWikiDatabase: SWWikiDatabase): SpecieDao =
        sWWikiDatabase.specieDao()

    @Provides
    fun provideStarshipDao(sWWikiDatabase: SWWikiDatabase): StarshipDao =
        sWWikiDatabase.starshipDao()

    @Provides
    fun provideVehicleDao(sWWikiDatabase: SWWikiDatabase): VehicleDao =
        sWWikiDatabase.vehicleDao()
}
