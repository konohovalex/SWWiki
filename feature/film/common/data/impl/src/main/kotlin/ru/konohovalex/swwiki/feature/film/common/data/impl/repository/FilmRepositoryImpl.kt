package ru.konohovalex.swwiki.feature.film.common.data.impl.repository

import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.film.common.data.api.database.FilmDao
import ru.konohovalex.swwiki.feature.film.common.data.api.dto.FilmDto
import ru.konohovalex.swwiki.feature.film.common.data.api.dto.FilmsPagingDto
import ru.konohovalex.swwiki.feature.film.common.data.api.entity.FilmEntity
import ru.konohovalex.swwiki.feature.film.common.data.api.network.FilmApi
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import ru.konohovalex.swwiki.feature.film.common.domain.api.repository.FilmRepository
import java.io.IOException
import javax.inject.Inject

internal class FilmRepositoryImpl
@Inject constructor(
    private val filmCache: RuntimeCache<Int, FilmModel>,
    private val filmApi: FilmApi,
    private val filmDao: FilmDao,
    private val dtoToEntityMapper: Mapper<FilmDto, FilmEntity>,
    private val entityToModelMapper: Mapper<FilmEntity, FilmModel>,
//    private val databaseRecordOutdatedUseCase: DatabaseRecordOutdatedUseCase<FilmEntity>,
) : FilmRepository {
    override suspend fun getAllFilms(page: Int): List<FilmModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getFilm(id: Int): FilmModel? {
        filmCache.get(id)?.let { return it }

        getStoredFilm(id)?.let {
            val model = entityToModelMapper(it)
            filmCache.put(model.id, model)
            return model
        }

        return getRemoteFilm(id)?.let { remote ->
            val entity = dtoToEntityMapper(remote)
            storeFilms(entity)
            val model = entityToModelMapper(entity)
            filmCache.put(model.id, model)
            model
        }
    }

    override suspend fun findFilms(
        page: Int,
        query: String
    ): List<FilmModel> {
        TODO("Not yet implemented")
    }

    private suspend fun getAllRemoteFilms(page: Int): FilmsPagingDto? =
        try {
            filmApi.getAllFilms(page)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun getRemoteFilm(id: Int): FilmDto? = try {
        filmApi.getFilm(id)
    } catch (_: IOException) {
        null
    } catch (_: Throwable) {
        null
    }

    private suspend fun findAllRemoteFilms(page: Int, query: String): FilmsPagingDto? =
        try {
            filmApi.findFilms(page, query)
        } catch (_: IOException) {
            null
        } catch (_: Throwable) {
            null
        }

    private suspend fun storeFilms(vararg films: FilmEntity) =
        filmDao.insertOrReplace(*films)

    private suspend fun getStoredFilm(id: Int): FilmEntity? =
        filmDao.get(id)?.takeIf { /*databaseRecordOutdatedUseCase(it).not()*/true }

    private suspend fun findStoredFilmsByTitle(title: String): List<FilmEntity> =
        filmDao.findByTitle(title)

    private suspend fun getAllStoredFilms(): List<FilmEntity> =
        filmDao.getAll()

    private suspend fun deleteStoredFilms(ids: List<Int>) =
        filmDao.delete(ids)
}
