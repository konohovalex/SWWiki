package ru.konohovalex.swwiki.feature.film.common.domain.api

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.film.common.domain.api.repository.FilmRepository

interface IFilmDomainComponent : IComponent {
    fun filmRepository(): FilmRepository
}
