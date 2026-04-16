package ru.konohovalex.swwiki.feature.main.impl.presentation.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.main.impl.domain.model.Topic
import ru.konohovalex.swwiki.feature.main.impl.presentation.mapper.TopicToTopicUiModelMapper
import ru.konohovalex.swwiki.feature.main.impl.presentation.model.TopicUiModel

@Module
internal interface MainUiMapperModule {
    @Binds
    fun bindTopicToTopicUiModelMapper(impl: TopicToTopicUiModelMapper): Mapper<Topic, TopicUiModel>
}
