import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.lifecycle)
    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.character.search.presentation.impl"
}

dependencies(
    Implementation(projects.core.coroutines),
    Implementation(projects.core.di),
    Implementation(projects.core.functional),
    Implementation(projects.core.navigation),
    Implementation(projects.core.ui),
    Implementation(projects.core.viewmodel),

    Implementation(projects.feature.character.details.presentation.api),
    Implementation(projects.feature.character.search.domain.api),
    Implementation(projects.feature.character.search.presentation.api),

    Implementation(libs.androidx.navigation3.runtime),
    Implementation(libs.androidx.navigation3.ui),
    Implementation(libs.androidx.paging.runtimeKtx),
    Implementation(libs.androidx.paging.compose),
)
