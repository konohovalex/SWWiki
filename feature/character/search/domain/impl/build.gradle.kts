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

    Implementation(projects.feature.character.common.domain.api),
    Implementation(projects.feature.character.search.domain.api),
)
