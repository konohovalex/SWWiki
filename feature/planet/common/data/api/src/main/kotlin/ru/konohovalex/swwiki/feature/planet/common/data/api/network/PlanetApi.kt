package ru.konohovalex.swwiki.feature.planet.common.data.api.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.konohovalex.swwiki.feature.planet.common.data.api.dto.PlanetDto
import ru.konohovalex.swwiki.feature.planet.common.data.api.dto.PlanetsPagingDto

interface PlanetApi {
    @GET("planets")
    suspend fun getAllPlanets(@Query("page") page: Int): PlanetsPagingDto

    @GET("planets/{id}")
    suspend fun getPlanet(@Path("id") id: Int): PlanetDto

    @GET("planets")
    suspend fun findPlanets(
        @Query("page") page: Int,
        @Query("search") query: String,
    ): PlanetsPagingDto
}
