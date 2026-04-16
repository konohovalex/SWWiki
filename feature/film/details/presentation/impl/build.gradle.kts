import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.lifecycle)
    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.film.details.presentation.impl"
}

dependencies(
    Implementation(projects.core.functional),
    Implementation(projects.core.di),
    Implementation(projects.core.ui),

    Implementation(projects.feature.film.details.domain.api),
    Implementation(projects.feature.film.details.presentation.api),
)
