import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.feature.impl)

    alias(libs.plugins.swwiki.dagger)
    alias(libs.plugins.swwiki.android.lifecycle)
    alias(libs.plugins.swwiki.android.library.compose)
}

android {
    namespace = "ru.konohovalex.swwiki.feature.main.impl"
}

dependencies(
    Implementation(projects.core.cache),
    Implementation(projects.core.database),
    Implementation(projects.core.di),
    Implementation(projects.core.functional),
    Implementation(projects.core.navigation),
    Implementation(projects.core.network),
    Implementation(projects.core.servicelocator),
    Implementation(projects.core.viewmodel),
    Implementation(projects.core.ui),

    Implementation(projects.feature.main.api),

    Implementation(projects.feature.character.common.data.impl),
    Implementation(projects.feature.character.details.domain.api),
    Implementation(projects.feature.character.details.domain.impl),
    Implementation(projects.feature.character.details.presentation.api),
    Implementation(projects.feature.character.details.presentation.impl),
    Implementation(projects.feature.character.search.domain.api),
    Implementation(projects.feature.character.search.domain.impl),
    Implementation(projects.feature.character.search.presentation.api),
    Implementation(projects.feature.character.search.presentation.impl),

    Implementation(projects.feature.film.common.data.impl),
    Implementation(projects.feature.film.details.domain.impl),
    Implementation(projects.feature.film.details.presentation.impl),

    Implementation(projects.feature.planet.common.data.impl),
    Implementation(projects.feature.planet.details.domain.impl),
    Implementation(projects.feature.planet.details.presentation.impl),

    Implementation(projects.feature.specie.common.data.impl),
    Implementation(projects.feature.specie.details.domain.impl),
    Implementation(projects.feature.specie.details.presentation.impl),

    Implementation(projects.feature.starship.common.data.impl),
    Implementation(projects.feature.starship.details.domain.impl),
    Implementation(projects.feature.starship.details.presentation.impl),

    Implementation(projects.feature.vehicle.common.data.impl),
    Implementation(projects.feature.vehicle.details.domain.impl),
    Implementation(projects.feature.vehicle.details.presentation.impl),

    Implementation(libs.androidx.navigation3.runtime),
    Implementation(libs.androidx.navigation3.ui),
)
