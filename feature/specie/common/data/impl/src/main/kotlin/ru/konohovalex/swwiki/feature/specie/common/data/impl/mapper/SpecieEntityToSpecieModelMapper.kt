package ru.konohovalex.swwiki.feature.specie.common.data.impl.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.specie.common.data.api.entity.SpecieEntity
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import javax.inject.Inject

internal class SpecieEntityToSpecieModelMapper
@Inject constructor() : Mapper<SpecieEntity, SpecieModel> {
    override fun invoke(source: SpecieEntity): SpecieModel = with(source) {
        SpecieModel(
            id = id,
            name = name,
            classification = classification,
            designation = designation,
            averageHeight = averageHeight,
            averageLifespan = averageLifespan,
            eyeColors = eyeColors,
            hairColors = hairColors,
            skinColors = skinColors,
            language = language,
            homeworldId = homeworldId,
            characterId = characterId,
            filmIds = filmIds,
        )
    }
}
