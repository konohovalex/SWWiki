package ru.konohovalex.swwiki.feature.specie.common.data.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.specie.common.data.api.dto.SpecieDto
import ru.konohovalex.swwiki.feature.specie.common.data.api.entity.SpecieEntity
import ru.konohovalex.swwiki.feature.specie.common.data.impl.mapper.SpecieDtoToSpecieEntityMapper
import ru.konohovalex.swwiki.feature.specie.common.data.impl.mapper.SpecieEntityToSpecieModelMapper
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel

@Module
internal interface SpecieDomainMapperModule {
    @Binds
    fun bindSpecieDtoToSpecieEntityMapper(
        impl: SpecieDtoToSpecieEntityMapper
    ): Mapper<SpecieDto, SpecieEntity>

    @Binds
    fun bindSpecieEntityToSpecieModelMapper(
        impl: SpecieEntityToSpecieModelMapper
    ): Mapper<SpecieEntity, SpecieModel>
}
