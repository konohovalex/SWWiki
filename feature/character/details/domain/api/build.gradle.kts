import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.character.details.domain.api"
}

dependencies(
    Implementation(projects.core.di),
    Implementation(projects.core.functional),
    Implementation(projects.core.network),

    Implementation(projects.feature.character.common.domain.api),
    Implementation(projects.feature.film.common.domain.api),
    Implementation(projects.feature.specie.common.domain.api),
    Implementation(projects.feature.starship.common.domain.api),
    Implementation(projects.feature.vehicle.common.domain.api),
)
