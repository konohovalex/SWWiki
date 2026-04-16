package ru.konohovalex.swwiki.feature.main.impl.presentation.model

import androidx.annotation.StringRes
import ru.konohovalex.swwiki.feature.main.api.R

enum class TopicUiModel(@param:StringRes @get:StringRes val titleRes: Int) {
    CHARACTERS(titleRes = R.string.feature_main_api_topic_characters),
    FILMS(titleRes = R.string.feature_main_api_topic_films),
    PLANETS(titleRes = R.string.feature_main_api_topic_planets),
    SPECIES(titleRes = R.string.feature_main_api_topic_species),
    STARSHIPS(titleRes = R.string.feature_main_api_topic_starships),
    VEHICLES(titleRes = R.string.feature_main_api_topic_vehicles),
}
