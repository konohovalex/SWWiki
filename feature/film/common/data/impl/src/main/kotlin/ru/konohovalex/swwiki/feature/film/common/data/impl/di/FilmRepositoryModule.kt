package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.film.common.data.api.database.FilmDao
import ru.konohovalex.swwiki.feature.film.common.data.api.dto.FilmDto
import ru.konohovalex.swwiki.feature.film.common.data.api.entity.FilmEntity
import ru.konohovalex.swwiki.feature.film.common.data.api.network.FilmApi
import ru.konohovalex.swwiki.feature.film.common.data.impl.repository.FilmRepositoryImpl
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import ru.konohovalex.swwiki.feature.film.common.domain.api.repository.FilmRepository

@Module
internal class FilmRepositoryModule {
    @Provides
    fun bindFilmRepository(
        filmCache: RuntimeCache<Int, FilmModel>,
        filmApi: FilmApi,
        filmDao: FilmDao,
        dtoToEntityMapper: Mapper<FilmDto, FilmEntity>,
        entityToModelMapper: Mapper<FilmEntity, FilmModel>,
    ): FilmRepository = FilmRepositoryImpl(
        filmCache,
        filmApi,
        filmDao,
        dtoToEntityMapper,
        entityToModelMapper,
    )
}
