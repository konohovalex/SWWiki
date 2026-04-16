package ru.konohovalex.swwiki.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.konohovalex.swwiki.core.database.converter.IntListConverter
import ru.konohovalex.swwiki.core.database.converter.LocalDateTimeTypeConverter
import ru.konohovalex.swwiki.core.database.converter.LocalDateTypeConverter
import ru.konohovalex.swwiki.feature.character.common.data.api.database.CharacterDao
import ru.konohovalex.swwiki.feature.character.common.data.api.entity.CharacterEntity
import ru.konohovalex.swwiki.feature.film.common.data.api.database.FilmDao
import ru.konohovalex.swwiki.feature.film.common.data.api.entity.FilmEntity
import ru.konohovalex.swwiki.feature.planet.common.data.api.database.PlanetDao
import ru.konohovalex.swwiki.feature.planet.common.data.api.entity.PlanetEntity
import ru.konohovalex.swwiki.feature.specie.common.data.api.database.SpecieDao
import ru.konohovalex.swwiki.feature.specie.common.data.api.entity.SpecieEntity
import ru.konohovalex.swwiki.feature.starship.common.data.api.database.StarshipDao
import ru.konohovalex.swwiki.feature.starship.common.data.api.entity.StarshipEntity
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.database.VehicleDao
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity.VehicleEntity

@Database(
    version = 1,
    entities = [
        CharacterEntity::class,
        FilmEntity::class,
        PlanetEntity::class,
        SpecieEntity::class,
        StarshipEntity::class,
        VehicleEntity::class,
    ],
)
@TypeConverters(
    value = [
        IntListConverter::class,
        LocalDateTypeConverter::class,
        LocalDateTimeTypeConverter::class,
    ]
)
internal abstract class SWWikiDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun filmDao(): FilmDao
    abstract fun planetDao(): PlanetDao
    abstract fun specieDao(): SpecieDao
    abstract fun starshipDao(): StarshipDao
    abstract fun vehicleDao(): VehicleDao
}
