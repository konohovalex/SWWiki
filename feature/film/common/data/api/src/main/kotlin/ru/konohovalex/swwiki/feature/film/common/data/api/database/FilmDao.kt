package ru.konohovalex.swwiki.feature.film.common.data.api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.konohovalex.swwiki.feature.film.common.data.api.entity.FilmEntity

@Dao
interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(vararg films: FilmEntity)

    @Query("SELECT * FROM film WHERE id = :id")
    suspend fun get(id: Int): FilmEntity?

    @Query("SELECT * FROM film WHERE title LIKE '%' || :title || '%'")
    suspend fun findByTitle(title: String): List<FilmEntity>

    @Query("SELECT * FROM film")
    suspend fun getAll(): List<FilmEntity>

    @Query("DELETE FROM film WHERE id IN (:ids)")
    suspend fun delete(ids: List<Int>)
}
