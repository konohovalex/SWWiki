package ru.konohovalex.swwiki.feature.character.common.data.api.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.konohovalex.swwiki.feature.character.common.data.api.dto.CharacterDto
import ru.konohovalex.swwiki.feature.character.common.data.api.dto.CharactersPagingDto

interface CharacterApi {
    @GET("people")
    suspend fun getAllCharacters(@Query("page") page: Int): CharactersPagingDto

    @GET("people/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDto

    @GET("people")
    suspend fun findCharacters(
        @Query("page") page: Int,
        @Query("search") query: String,
    ): CharactersPagingDto
}
