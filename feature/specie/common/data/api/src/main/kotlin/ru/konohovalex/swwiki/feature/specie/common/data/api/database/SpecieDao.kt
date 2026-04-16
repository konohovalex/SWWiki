package ru.konohovalex.swwiki.feature.specie.common.data.api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.konohovalex.swwiki.feature.specie.common.data.api.entity.SpecieEntity

@Dao
interface SpecieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg species: SpecieEntity)

    @Query("SELECT * FROM specie WHERE id = :id")
    suspend fun get(id: Int): SpecieEntity?

    @Query("SELECT * FROM specie WHERE name LIKE '%' || :name || '%'")
    suspend fun findByName(name: String): List<SpecieEntity>

    @Query("SELECT * FROM specie")
    suspend fun getAll(): List<SpecieEntity>

    @Query("DELETE FROM specie WHERE id IN (:ids)")
    suspend fun delete(ids: List<Int>)
}
