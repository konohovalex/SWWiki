import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.Implementation

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

    Api(projects.feature.character.details.presentation.api),
    Api(projects.feature.character.search.domain.api),
    Api(projects.feature.character.search.presentation.api),

    Implementation(libs.androidx.navigation3.runtime),
    Implementation(libs.androidx.navigation3.ui),
    Implementation(libs.androidx.paging.runtimeKtx),
    Implementation(libs.androidx.paging.compose),
)
