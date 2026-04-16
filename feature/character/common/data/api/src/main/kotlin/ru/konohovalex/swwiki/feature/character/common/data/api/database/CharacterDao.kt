package ru.konohovalex.swwiki.feature.character.common.data.api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.konohovalex.swwiki.feature.character.common.data.api.entity.CharacterEntity

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg characters: CharacterEntity)

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun get(id: Int): CharacterEntity?

    @Query("SELECT * FROM character WHERE name LIKE '%' || :name || '%'")
    suspend fun findByName(name: String): List<CharacterEntity>

    @Query("SELECT * FROM character")
    suspend fun getAll(): List<CharacterEntity>

    @Query("DELETE FROM character WHERE id IN (:ids)")
    suspend fun delete(ids: List<Int>)
}
