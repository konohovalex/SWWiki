package ru.konohovalex.swwiki.feature.film.common.data.api.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.konohovalex.swwiki.feature.film.common.data.api.dto.FilmDto
import ru.konohovalex.swwiki.feature.film.common.data.api.dto.FilmsPagingDto

interface FilmApi {
    @GET("films")
    suspend fun getAllFilms(@Query("page") page: Int): FilmsPagingDto

    @GET("films/{id}")
    suspend fun getFilm(@Path("id") id: Int): FilmDto

    @GET("films")
    suspend fun findFilms(
        @Query("page") page: Int,
        @Query("search") query: String,
    ): FilmsPagingDto
}
