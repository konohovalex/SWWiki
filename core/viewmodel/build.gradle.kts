import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.library)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.core.viewmodel"
}

dependencies(
    Implementation(projects.core.di),

    Implementation(libs.androidx.lifecycle.viewModel.ktx),
    Implementation(libs.androidx.lifecycle.viewModel.compose),
    Implementation(libs.androidx.lifecycle.viewModel.savedstate),
)
