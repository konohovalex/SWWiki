package ru.konohovalex.swwiki.feature.starship.common.data.api.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.konohovalex.swwiki.feature.starship.common.data.api.dto.StarshipDto
import ru.konohovalex.swwiki.feature.starship.common.data.api.dto.StarshipsPagingDto

interface StarshipApi {
    @GET("starships")
    suspend fun getAllStarships(@Query("page") page: Int): StarshipsPagingDto

    @GET("starships/{id}")
    suspend fun getStarship(@Path("id") id: Int): StarshipDto

    @GET("starships")
    suspend fun findStarships(
        @Query("page") page: Int,
        @Query("search") query: String,
    ): StarshipsPagingDto
}
