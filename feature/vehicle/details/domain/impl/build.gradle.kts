import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.vehicle.details.domain.impl"
}

dependencies(
    Implementation(projects.core.cache),
    Implementation(projects.core.di),
    Implementation(projects.core.functional),
    Implementation(projects.core.network),

    Implementation(projects.feature.vehicle.details.domain.api),
)
