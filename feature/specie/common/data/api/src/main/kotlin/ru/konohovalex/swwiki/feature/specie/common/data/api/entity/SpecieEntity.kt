package ru.konohovalex.swwiki.feature.specie.common.data.api.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "specie")
data class SpecieEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val averageLifespan: String,
    val eyeColors: String,
    val hairColors: String,
    val skinColors: String,
    val language: String,
    val homeworldId: Int?,
    val characterId: List<Int>,
    val filmIds: List<Int>,
    val editedDate: LocalDateTime,
)
