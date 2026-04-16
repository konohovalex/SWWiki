package ru.konohovalex.swwiki.feature.specie.common.data.api.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.konohovalex.swwiki.feature.specie.common.data.api.dto.SpecieDto
import ru.konohovalex.swwiki.feature.specie.common.data.api.dto.SpeciesPagingDto

interface SpecieApi {
    @GET("species")
    suspend fun getAllSpecies(@Query("page") page: Int): SpeciesPagingDto

    @GET("species/{id}")
    suspend fun getSpecie(@Path("id") id: Int): SpecieDto

    @GET("species")
    suspend fun findSpecies(
        @Query("page") page: Int,
        @Query("search") query: String,
    ): SpeciesPagingDto
}
