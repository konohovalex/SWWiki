package ru.konohovalex.swwiki.feature.planet.common.data.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.planet.common.data.api.dto.PlanetDto
import ru.konohovalex.swwiki.feature.planet.common.data.api.entity.PlanetEntity
import ru.konohovalex.swwiki.feature.planet.common.data.impl.mapper.PlanetDtoToPlanetEntityMapper
import ru.konohovalex.swwiki.feature.planet.common.data.impl.mapper.PlanetEntityToPlanetModelMapper
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel

@Module
internal interface PlanetDomainMapperModule {
    @Binds
    fun bindPlanetDtoToPlanetEntityMapper(
        impl: PlanetDtoToPlanetEntityMapper
    ): Mapper<PlanetDto, PlanetEntity>

    @Binds
    fun bindPlanetEntityToPlanetModelMapper(
        impl: PlanetEntityToPlanetModelMapper
    ): Mapper<PlanetEntity, PlanetModel>
}
