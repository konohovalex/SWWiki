import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.planet.search.domain.impl"
}

dependencies(
    Implementation(projects.core.functional),
    Implementation(projects.core.di),

    Implementation(projects.feature.planet.search.domain.api),
)
