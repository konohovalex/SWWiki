package ru.konohovalex.swwiki.feature.character.details.domain.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel
import javax.inject.Inject

class VehicleModelToCharacterDetailsVehicleMapper
@Inject constructor() : Mapper<VehicleModel, CharacterDetailsModel.Vehicle> {
    override fun invoke(source: VehicleModel): CharacterDetailsModel.Vehicle = with(source) {
        CharacterDetailsModel.Vehicle(
            id = id,
            name = name,
            model = model,
        )
    }
}
