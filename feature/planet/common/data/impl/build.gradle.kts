import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.planet.common.data.impl"
}

dependencies(
    Implementation(projects.core.cache),
    Implementation(projects.core.database),
    Implementation(projects.core.di),
    Implementation(projects.core.functional),
    Implementation(projects.core.network),

    Api(projects.feature.planet.common.data.api),
    Api(projects.feature.planet.common.domain.api),
)
