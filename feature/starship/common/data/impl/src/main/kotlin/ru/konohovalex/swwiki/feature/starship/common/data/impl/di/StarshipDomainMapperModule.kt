package ru.konohovalex.swwiki.feature.starship.common.data.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.starship.common.data.api.dto.StarshipDto
import ru.konohovalex.swwiki.feature.starship.common.data.api.entity.StarshipEntity
import ru.konohovalex.swwiki.feature.starship.common.data.impl.mapper.StarshipDtoToStarshipEntityMapper
import ru.konohovalex.swwiki.feature.starship.common.data.impl.mapper.StarshipEntityToStarshipModelMapper
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel

@Module
internal interface StarshipDomainMapperModule {
    @Binds
    fun bindStarshipDtoToStarshipEntityMapper(
        impl: StarshipDtoToStarshipEntityMapper
    ): Mapper<StarshipDto, StarshipEntity>

    @Binds
    fun bindStarshipEntityToStarshipModelMapper(
        impl: StarshipEntityToStarshipModelMapper
    ): Mapper<StarshipEntity, StarshipModel>
}
