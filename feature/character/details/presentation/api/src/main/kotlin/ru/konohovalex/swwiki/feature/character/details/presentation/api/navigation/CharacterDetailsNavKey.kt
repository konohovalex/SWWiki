package ru.konohovalex.swwiki.feature.character.details.presentation.api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetailsNavKey(
    val id: Int,
    val name: String,
): NavKey
