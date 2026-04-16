package ru.konohovalex.swwiki.feature.vehicle.common.data.api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity.VehicleEntity

@Dao
interface VehicleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg vehicles: VehicleEntity)

    @Query("SELECT * FROM vehicle WHERE id = :id")
    suspend fun get(id: Int): VehicleEntity?

    @Query("SELECT * FROM vehicle WHERE name LIKE '%' || :name || '%'")
    suspend fun findByName(name: String): List<VehicleEntity>

    @Query("SELECT * FROM vehicle")
    suspend fun getAll(): List<VehicleEntity>

    @Query("DELETE FROM vehicle WHERE id IN (:ids)")
    suspend fun delete(ids: List<Int>)
}
