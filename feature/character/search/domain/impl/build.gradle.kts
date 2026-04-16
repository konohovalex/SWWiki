import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.character.search.domain.impl"
}

dependencies(
    Implementation(projects.core.functional),
    Implementation(projects.core.di),

    Api(projects.feature.character.common.domain.api),
    Api(projects.feature.character.search.domain.api),
)
