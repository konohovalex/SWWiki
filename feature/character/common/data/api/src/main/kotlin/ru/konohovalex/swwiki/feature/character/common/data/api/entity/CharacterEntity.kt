package ru.konohovalex.swwiki.feature.character.common.data.api.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: Int,
    val hairColor: String,
    val height: Int,
    val mass: Int,
    val skinColor: String,
    val homeworldId: Int?,
    val filmIds: List<Int>,
    val specieIds: List<Int>,
    val starshipIds: List<Int>,
    val vehicleIds: List<Int>,
    val editedDate: LocalDateTime,
)
