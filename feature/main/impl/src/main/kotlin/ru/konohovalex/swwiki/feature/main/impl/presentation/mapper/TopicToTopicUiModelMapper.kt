package ru.konohovalex.swwiki.feature.main.impl.presentation.mapper

import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.main.impl.domain.model.Topic
import ru.konohovalex.swwiki.feature.main.impl.presentation.model.TopicUiModel
import javax.inject.Inject

internal class TopicToTopicUiModelMapper
@Inject constructor() : Mapper<Topic, TopicUiModel> {
    override fun invoke(source: Topic): TopicUiModel = when (source) {
        Topic.CHARACTERS -> TopicUiModel.CHARACTERS
        Topic.FILMS -> TopicUiModel.FILMS
        Topic.PLANETS -> TopicUiModel.PLANETS
        Topic.SPECIES -> TopicUiModel.SPECIES
        Topic.STARSHIPS -> TopicUiModel.STARSHIPS
        Topic.VEHICLES -> TopicUiModel.VEHICLES
    }
}
