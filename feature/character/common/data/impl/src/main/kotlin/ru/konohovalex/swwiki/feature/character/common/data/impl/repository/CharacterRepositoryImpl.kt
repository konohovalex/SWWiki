package ru.konohovalex.swwiki.feature.character.common.data.impl.repository

import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.common.data.api.database.CharacterDao
import ru.konohovalex.swwiki.feature.character.common.data.api.dto.CharacterDto
import ru.konohovalex.swwiki.feature.character.common.data.api.dto.CharactersPagingDto
import ru.konohovalex.swwiki.feature.character.common.data.api.entity.CharacterEntity
import ru.konohovalex.swwiki.feature.character.common.data.api.network.CharacterApi
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharactersPagingModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository
import java.io.IOException
import javax.inject.Inject

internal class CharacterRepositoryImpl
@Inject constructor(
    private val characterCache: RuntimeCache<Int, CharacterModel>,
    private val characterApi: CharacterApi,
    private val characterDao: CharacterDao,
    private val dtoToEntityMapper: Mapper<CharacterDto, CharacterEntity>,
    private val entityToModelMapper: Mapper<CharacterEntity, CharacterModel>,
    // TODO(implement)
//    private val databaseRecordOutdatedUseCase: DatabaseRecordOutdatedUseCase<CharacterEntity>,
) : CharacterRepository {
    override suspend fun getAllCharacters(page: Int): CharactersPagingModel =
        getAllRemoteCharacters(page).toCharacterPagingModel()


    override suspend fun getCharacter(id: Int): CharacterModel? {
        characterCache.get(id)?.let { return it }

        getStoredCharacter(id)?.let {
            val model = entityToModelMapper(it)
            characterCache.put(model.id, model)
            return model
        }

        return getRemoteCharacter(id)?.cacheAndStore()
    }

    override suspend fun findCharacters(page: Int, query: String): CharactersPagingModel =
        findAllRemoteCharacters(page, query).toCharacterPagingModel()

    private suspend fun getAllRemoteCharacters(page: Int): CharactersPagingDto =
        characterApi.getAllCharacters(page)

    private suspend fun getRemoteCharacter(id: Int): CharacterDto? = try {
        characterApi.getCharacter(id)
    } catch (_: IOException) {
        null
    } catch (_: Throwable) {
        null
    }

    private suspend fun findAllRemoteCharacters(page: Int, query: String): CharactersPagingDto =
        characterApi.findCharacters(page, query)

    private suspend fun CharacterDto.cacheAndStore() = dtoToEntityMapper(this).let {
        storeCharacters(it)
        val model = entityToModelMapper(it)
        characterCache.put(model.id, model)
        model
    }

    private suspend fun CharactersPagingDto.toCharacterPagingModel() =
        CharactersPagingModel(
            next = next,
            results = results.map { characterDto ->
                characterDto.cacheAndStore()
            }
        )

    private suspend fun storeCharacters(vararg characters: CharacterEntity) =
        characterDao.insertOrReplace(*characters)

    private suspend fun getStoredCharacter(id: Int): CharacterEntity? =
        characterDao.get(id)?.takeIf { /*databaseRecordOutdatedUseCase(it).not()*/true }

    private suspend fun findStoredCharactersByName(name: String): List<CharacterEntity> =
        characterDao.findByName(name)

    private suspend fun getAllStoredCharacters(): List<CharacterEntity> =
        characterDao.getAll()

    private suspend fun deleteStoredCharacters(ids: List<Int>) =
        characterDao.delete(ids)
}
