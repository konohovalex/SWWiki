package ru.konohovalex.swwiki.feature.specie.common.data.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class SpecieDto(
    val name: String,
    val classification: String,
    val designation: String,
    @SerialName("average_height")
    val averageHeight: String,
    @SerialName("average_lifespan")
    val averageLifespan: String,
    @SerialName("eye_colors")
    val eyeColors: String,
    @SerialName("hair_colors")
    val hairColors: String,
    @SerialName("skin_colors")
    val skinColors: String,
    val language: String,
    @SerialName("homeworld")
    val homeworldUrl: String?,
    @SerialName("people")
    val characterUrls: List<String>,
    @SerialName("films")
    val filmUrls: List<String>,
    val url: String,
    @SerialName("edited")
    val editedDate: Instant,
)
