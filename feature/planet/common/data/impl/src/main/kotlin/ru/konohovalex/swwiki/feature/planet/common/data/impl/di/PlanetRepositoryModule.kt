package ru.konohovalex.swwiki.feature.planet.common.data.impl.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.planet.common.data.api.database.PlanetDao
import ru.konohovalex.swwiki.feature.planet.common.data.api.dto.PlanetDto
import ru.konohovalex.swwiki.feature.planet.common.data.api.entity.PlanetEntity
import ru.konohovalex.swwiki.feature.planet.common.data.api.network.PlanetApi
import ru.konohovalex.swwiki.feature.planet.common.data.impl.repository.PlanetRepositoryImpl
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import ru.konohovalex.swwiki.feature.planet.common.domain.api.repository.PlanetRepository

@Module
internal class PlanetRepositoryModule {
    @Provides
    fun bindFilmRepository(
        planetCache: RuntimeCache<Int, PlanetModel>,
        planetApi: PlanetApi,
        planetDao: PlanetDao,
        dtoToEntityMapper: Mapper<PlanetDto, PlanetEntity>,
        entityToModelMapper: Mapper<PlanetEntity, PlanetModel>,
    ): PlanetRepository = PlanetRepositoryImpl(
        planetCache,
        planetApi,
        planetDao,
        dtoToEntityMapper,
        entityToModelMapper,
    )
}
