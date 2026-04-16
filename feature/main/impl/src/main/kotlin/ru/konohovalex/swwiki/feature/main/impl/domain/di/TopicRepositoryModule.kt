package ru.konohovalex.swwiki.feature.main.impl.domain.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.feature.main.impl.domain.repository.api.TopicRepository
import ru.konohovalex.swwiki.feature.main.impl.domain.repository.impl.TopicRepositoryImpl

@Module
internal interface TopicRepositoryModule {
    @Binds
    fun bindTopicRepository(impl: TopicRepositoryImpl): TopicRepository
}
