import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.lifecycle)
    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.character.details.presentation.impl"
}

dependencies(
    Implementation(projects.core.coroutines),
    Implementation(projects.core.di),
    Implementation(projects.core.functional),
    Implementation(projects.core.navigation),
    Implementation(projects.core.servicelocator),
    Implementation(projects.core.ui),
    Implementation(projects.core.viewmodel),

    Implementation(projects.feature.character.details.domain.api),
    Implementation(projects.feature.character.details.presentation.api),

    Implementation(libs.androidx.navigation3.runtime),
    Implementation(libs.androidx.navigation3.ui),
)
