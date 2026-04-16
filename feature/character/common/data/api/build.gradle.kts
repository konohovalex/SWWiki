import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)

    alias(libs.plugins.swwiki.android.room)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.character.common.data.api"
}

dependencies(
    Implementation(projects.swwiki.core.functional),

    Implementation(projects.feature.character.common.domain.api),

    Implementation(libs.retrofit),
)
