import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.library)

    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.core.ui"
}

dependencies(
)
