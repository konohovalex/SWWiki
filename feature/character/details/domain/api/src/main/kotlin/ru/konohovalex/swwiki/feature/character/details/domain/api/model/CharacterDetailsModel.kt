package ru.konohovalex.swwiki.feature.character.details.domain.api.model

data class CharacterDetailsModel(
    val id: Int,
    val basicInformation: BasicInformation,
    val films: List<Film>,
    val species: List<Specie>,
    val starships: List<Starship>,
    val vehicles: List<Vehicle>,
) {
    data class BasicInformation(
        val name: String,
        val birthYear: String,
        val eyeColor: String,
        val gender: Int,
        val hairColor: String,
        val height: String,
        val mass: String,
        val skinColor: String,
        val homeworld: String?,
    )

    data class Film(
        val id: Int,
        val title: String,
        val openingCrawl: String,
    )

    data class Specie(
        val id: Int,
        val name: String,
    )

    data class Starship(
        val id: Int,
        val name: String,
        val model: String,
    )

    data class Vehicle(
        val id: Int,
        val name: String,
        val model: String,
    )
}
