import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.api)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.character.details.domain.api"
}

dependencies(
    Implementation(projects.core.functional),
    Implementation(projects.core.network),

    Api(projects.feature.character.common.domain.api),
    Api(projects.feature.film.common.domain.api),
    Api(projects.feature.specie.common.domain.api),
    Api(projects.feature.starship.common.domain.api),
    Api(projects.feature.vehicle.common.domain.api),
)
