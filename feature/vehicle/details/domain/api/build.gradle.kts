import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.vehicle.details.domain.api"
}

dependencies(
    Implementation(projects.core.functional),
    Implementation(projects.core.network),
)
