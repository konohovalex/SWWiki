package ru.konohovalex.swwiki.feature.specie.common.data.impl.di

import dagger.Module
import dagger.Provides
import ru.konohovalex.swwiki.core.cache.RuntimeCache
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.specie.common.data.api.database.SpecieDao
import ru.konohovalex.swwiki.feature.specie.common.data.api.dto.SpecieDto
import ru.konohovalex.swwiki.feature.specie.common.data.api.entity.SpecieEntity
import ru.konohovalex.swwiki.feature.specie.common.data.api.network.SpecieApi
import ru.konohovalex.swwiki.feature.specie.common.data.impl.repository.SpecieRepositoryImpl
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import ru.konohovalex.swwiki.feature.specie.common.domain.api.repository.SpecieRepository

@Module
internal class SpecieRepositoryModule {
    @Provides
    fun bindFilmRepository(
        specieCache: RuntimeCache<Int, SpecieModel>,
        specieApi: SpecieApi,
        specieDao: SpecieDao,
        dtoToEntityMapper: Mapper<SpecieDto, SpecieEntity>,
        entityToModelMapper: Mapper<SpecieEntity, SpecieModel>,
    ): SpecieRepository = SpecieRepositoryImpl(
        specieCache,
        specieApi,
        specieDao,
        dtoToEntityMapper,
        entityToModelMapper,
    )
}
