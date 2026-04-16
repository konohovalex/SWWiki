import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.starship.search.domain.impl"
}

dependencies(
    Implementation(projects.core.functional),
    Implementation(projects.core.di),

    Api(projects.feature.starship.search.domain.api),
)
