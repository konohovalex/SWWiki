import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.Implementation

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.lifecycle)
    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.planet.search.presentation.impl"
}

dependencies(
    Implementation(projects.core.functional),
    Implementation(projects.core.di),
    Implementation(projects.core.ui),

    Api(projects.feature.planet.search.presentation.api),
)
