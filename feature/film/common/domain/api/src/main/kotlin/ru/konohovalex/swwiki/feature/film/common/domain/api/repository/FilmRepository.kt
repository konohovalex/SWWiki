package ru.konohovalex.swwiki.feature.film.common.domain.api.repository

import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel

interface FilmRepository {
    suspend fun getAllFilms(page: Int): List<FilmModel>

    suspend fun getFilm(id: Int): FilmModel?

    suspend fun findFilms(page: Int, query: String): List<FilmModel>
}
