package ru.konohovalex.swwiki.feature.planet.common.data.api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.konohovalex.swwiki.feature.planet.common.data.api.entity.PlanetEntity

@Dao
interface PlanetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg planets: PlanetEntity)

    @Query("SELECT * FROM planet WHERE id = :id")
    suspend fun get(id: Int): PlanetEntity?

    @Query("SELECT * FROM planet WHERE name LIKE '%' || :name || '%'")
    suspend fun findByName(name: String): List<PlanetEntity>

    @Query("SELECT * FROM planet")
    suspend fun getAll(): List<PlanetEntity>

    @Query("DELETE FROM planet WHERE id IN (:ids)")
    suspend fun delete(ids: List<String>)
}
