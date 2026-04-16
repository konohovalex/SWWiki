package ru.konohovalex.swwiki.feature.film.common.domain.api

import ru.konohovalex.swwiki.feature.film.common.domain.api.repository.FilmRepository

interface IFilmDomainComponent {
    fun filmRepository(): FilmRepository
}
