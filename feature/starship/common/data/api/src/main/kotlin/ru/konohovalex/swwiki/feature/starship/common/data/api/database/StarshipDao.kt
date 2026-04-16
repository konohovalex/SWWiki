package ru.konohovalex.swwiki.feature.starship.common.data.api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.konohovalex.swwiki.feature.starship.common.data.api.entity.StarshipEntity

@Dao
interface StarshipDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg starships: StarshipEntity)

    @Query("SELECT * FROM starship WHERE id = :id")
    suspend fun get(id: Int): StarshipEntity?

    @Query("SELECT * FROM starship WHERE name LIKE '%' || :name || '%'")
    suspend fun findByName(name: String): List<StarshipEntity>

    @Query("SELECT * FROM starship")
    suspend fun getAll(): List<StarshipEntity>

    @Query("DELETE FROM starship WHERE id IN (:ids)")
    suspend fun delete(ids: List<Int>)
}
