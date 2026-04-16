import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.film.common.domain.api"
}

dependencies(
    Implementation(projects.core.di),
)
