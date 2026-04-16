package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.film.common.data.api.dto.FilmDto
import ru.konohovalex.swwiki.feature.film.common.data.api.entity.FilmEntity
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import ru.konohovalex.swwiki.feature.film.common.data.impl.mapper.FilmDtoToFilmEntityMapper
import ru.konohovalex.swwiki.feature.film.common.data.impl.mapper.FilmEntityToFilmModelMapper

@Module
internal interface FilmDomainMapperModule {
    @Binds
    fun bindFilmDtoToFilmEntityMapper(
        impl: FilmDtoToFilmEntityMapper
    ): Mapper<FilmDto, FilmEntity>

    @Binds
    fun bindFilmEntityToFilmModelMapper(
        impl: FilmEntityToFilmModelMapper
    ): Mapper<FilmEntity, FilmModel>
}
