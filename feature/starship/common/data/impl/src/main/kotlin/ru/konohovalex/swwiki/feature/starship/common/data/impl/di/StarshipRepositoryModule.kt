package ru.konohovalex.swwiki.feature.starship.common.data.impl.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.starship.common.data.api.database.StarshipDao
import ru.konohovalex.swwiki.feature.starship.common.data.api.dto.StarshipDto
import ru.konohovalex.swwiki.feature.starship.common.data.api.entity.StarshipEntity
import ru.konohovalex.swwiki.feature.starship.common.data.api.network.StarshipApi
import ru.konohovalex.swwiki.feature.starship.common.data.impl.repository.StarshipRepositoryImpl
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import ru.konohovalex.swwiki.feature.starship.common.domain.api.repository.StarshipRepository

@Module
internal class StarshipRepositoryModule {
    @Provides
    fun bindStarshipRepository(
        starshipCache: RuntimeCache<Int, StarshipModel>,
        starshipApi: StarshipApi,
        starshipDao: StarshipDao,
        dtoToEntityMapper: Mapper<StarshipDto, StarshipEntity>,
        entityToModelMapper: Mapper<StarshipEntity, StarshipModel>,
    ): StarshipRepository = StarshipRepositoryImpl(
        starshipCache,
        starshipApi,
        starshipDao,
        dtoToEntityMapper,
        entityToModelMapper,
    )
}
