package ru.konohovalex.swwiki.core.cache.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.cache.di.qualifier.DefaultTtlSeconds
import ru.konohovalex.swwiki.core.cache.di.qualifier.MaximumSize
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel
import javax.inject.Singleton
import kotlin.time.Duration.Companion.hours

@Module
internal class CacheModule {
    @[Provides DefaultTtlSeconds]
    fun bindDefaultTtl(): Long = 4.hours.inWholeSeconds

    @[Provides MaximumSize]
    fun bindMaximumSize(): Int = 128

    @[Provides Singleton]
    fun provideCharacterCache(
        @DefaultTtlSeconds defaultTtlSeconds: Long,
        @MaximumSize maximumSize: Int,
    ): RuntimeCache<Int, CharacterModel> =
        RuntimeCache(defaultTtlSeconds, maximumSize)

    @[Provides Singleton]
    fun provideFilmCache(
        @DefaultTtlSeconds defaultTtlSeconds: Long,
        @MaximumSize maximumSize: Int,
    ): RuntimeCache<Int, FilmModel> =
        RuntimeCache(defaultTtlSeconds, maximumSize)

    @[Provides Singleton]
    fun providePlanetCache(
        @DefaultTtlSeconds defaultTtlSeconds: Long,
        @MaximumSize maximumSize: Int,
    ): RuntimeCache<Int, PlanetModel> =
        RuntimeCache(defaultTtlSeconds, maximumSize)

    @[Provides Singleton]
    fun provideSpecieCache(
        @DefaultTtlSeconds defaultTtlSeconds: Long,
        @MaximumSize maximumSize: Int,
    ): RuntimeCache<Int, SpecieModel> =
        RuntimeCache(defaultTtlSeconds, maximumSize)

    @[Provides Singleton]
    fun provideStarshipCache(
        @DefaultTtlSeconds defaultTtlSeconds: Long,
        @MaximumSize maximumSize: Int,
    ): RuntimeCache<Int, StarshipModel> =
        RuntimeCache(defaultTtlSeconds, maximumSize)

    @[Provides Singleton]
    fun provideVehicleCache(
        @DefaultTtlSeconds defaultTtlSeconds: Long,
        @MaximumSize maximumSize: Int,
    ): RuntimeCache<Int, VehicleModel> =
        RuntimeCache(defaultTtlSeconds, maximumSize)
}
