import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.room)
}

android {
    namespace = "ru.konohovalex.swwiki.core.database"
}

dependencies(
    Implementation(projects.core.di),

    Api(projects.feature.character.common.data.api),
    Api(projects.feature.film.common.data.api),
    Api(projects.feature.planet.common.data.api),
    Api(projects.feature.specie.common.data.api),
    Api(projects.feature.starship.common.data.api),
    Api(projects.feature.vehicle.common.data.api),
)
