package ru.konohovalex.swwiki.core.network.di

import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.create
import ru.konohovalex.swwiki.core.network.di.qualifier.BaseUrl
import ru.konohovalex.swwiki.core.network.json.DefaultJsonBuilder
import ru.konohovalex.swwiki.core.network.rest.RetrofitClientBuilder
import ru.konohovalex.swwiki.feature.character.common.data.api.network.CharacterApi
import ru.konohovalex.swwiki.feature.film.common.data.api.network.FilmApi
import ru.konohovalex.swwiki.feature.planet.common.data.api.network.PlanetApi
import ru.konohovalex.swwiki.feature.specie.common.data.api.network.SpecieApi
import ru.konohovalex.swwiki.feature.starship.common.data.api.network.StarshipApi
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.network.VehicleApi
import javax.inject.Singleton

@Module
internal class NetworkModule {
    @[Provides BaseUrl]
    fun bindBaseUrl(): String = "https://swapi.dev/api/"

    @Provides
    fun provideJson(): Json = DefaultJsonBuilder().build()

    @[Provides Singleton]
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        json: Json,
    ): Retrofit = RetrofitClientBuilder(baseUrl, json).build()

    @Provides
    fun provideCharacterApi(retrofit: Retrofit) = retrofit.create<CharacterApi>()

    @Provides
    fun provideFilmApi(retrofit: Retrofit) = retrofit.create<FilmApi>()

    @Provides
    fun providePlanetApi(retrofit: Retrofit) = retrofit.create<PlanetApi>()

    @Provides
    fun provideSpecieApi(retrofit: Retrofit) = retrofit.create<SpecieApi>()

    @Provides
    fun provideStarshipApi(retrofit: Retrofit) = retrofit.create<StarshipApi>()

    @Provides
    fun provideVehicleApi(retrofit: Retrofit) = retrofit.create<VehicleApi>()
}
