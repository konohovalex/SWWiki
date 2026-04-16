package ru.konohovalex.swwiki.feature.character.details.domain.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.functional.Mapper2
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper.CharacterModelToCharacterDetailsBasicInformationMapper
import ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper.FilmModelToCharacterDetailsFilmMapper
import ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper.SpecieModelToCharacterDetailsSpecieMapper
import ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper.StarshipModelToCharacterDetailsStarshipMapper
import ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper.VehicleModelToCharacterDetailsVehicleMapper
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel

@Module
interface CharacterDetailsDomainMapperModule {
    @Binds
    fun bindCharacterModelToCharacterDetailsBasicInformationMapper(
        impl: CharacterModelToCharacterDetailsBasicInformationMapper,
    ): Mapper2<CharacterModel, PlanetModel?, CharacterDetailsModel.BasicInformation>

    @Binds
    fun bindFilmModelToCharacterDetailsFilmMapper(
        impl: FilmModelToCharacterDetailsFilmMapper,
    ): Mapper<FilmModel, CharacterDetailsModel.Film>

    @Binds
    fun bindSpecieModelToCharacterDetailsSpecieMapper(
        impl: SpecieModelToCharacterDetailsSpecieMapper,
    ): Mapper<SpecieModel, CharacterDetailsModel.Specie>

    @Binds
    fun bindStarshipModelToCharacterDetailsStarshipMapper(
        impl: StarshipModelToCharacterDetailsStarshipMapper,
    ): Mapper<StarshipModel, CharacterDetailsModel.Starship>

    @Binds
    fun bindVehicleModelToCharacterDetailsVehicleMapper(
        impl: VehicleModelToCharacterDetailsVehicleMapper,
    ): Mapper<VehicleModel, CharacterDetailsModel.Vehicle>
}
