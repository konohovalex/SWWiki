import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.jvm.library)

    alias(libs.plugins.swwiki.kotlin.coroutines.android)
    alias(libs.plugins.swwiki.dagger)
}

dependencies(
    Implementation(projects.core.di),
)
