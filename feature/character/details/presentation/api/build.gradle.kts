import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.character.details.presentation.api"
}

dependencies(
    Implementation(libs.androidx.navigation3.runtime),
)
