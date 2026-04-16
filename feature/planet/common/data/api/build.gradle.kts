import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)

    alias(libs.plugins.swwiki.android.room)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.planet.common.data.api"
}

dependencies(
    Implementation(projects.swwiki.core.functional),

    Api(projects.feature.planet.common.domain.api),

    Implementation(libs.retrofit),
)
