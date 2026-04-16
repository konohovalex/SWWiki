import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.core.navigation"
}

dependencies(
    Implementation(projects.core.di),
    Implementation(projects.core.viewmodel),

    Implementation(libs.androidx.navigation3.runtime),
)
