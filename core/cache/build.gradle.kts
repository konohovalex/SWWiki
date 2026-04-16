import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.kotlin.coroutines.android)
    alias(libs.plugins.swwiki.dagger)
}

android {
    namespace = "ru.konohovalex.swwiki.core.cache"
}

dependencies(
    Implementation(projects.core.di),

    Api(projects.feature.character.common.domain.api),
    Api(projects.feature.film.common.domain.api),
    Api(projects.feature.planet.common.domain.api),
    Api(projects.feature.specie.common.domain.api),
    Api(projects.feature.starship.common.domain.api),
    Api(projects.feature.vehicle.common.domain.api),
)
