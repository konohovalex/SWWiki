package ru.konohovalex.swwiki.feature.character.common.data.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class CharacterDto(
    val name: String,
    @SerialName("birth_year")
    val birthYear: String,
    @SerialName("eye_color")
    val eyeColor: String,
    val gender: Gender,
    @SerialName("hair_color")
    val hairColor: String,
    val height: String,
    val mass: String,
    @SerialName("skin_color")
    val skinColor: String,
    @SerialName("homeworld")
    val homeworldUrl: String?,
    @SerialName("films")
    val filmUrls: List<String>,
    @SerialName("species")
    val specieUrls: List<String>,
    @SerialName("starships")
    val starshipUrls: List<String>,
    @SerialName("vehicles")
    val vehicleUrls: List<String>,
    val url: String,
    @SerialName("edited")
    val editedDate: Instant,
) {
    @Serializable
    enum class Gender {
        @SerialName("male")
        MALE,

        @SerialName("female")
        FEMALE,

        @SerialName("hermaphrodite")
        HERMAPHRODITE,

        @SerialName("n/a")
        NOT_AVAILABLE,

        @SerialName("none")
        NONE,
    }

}
