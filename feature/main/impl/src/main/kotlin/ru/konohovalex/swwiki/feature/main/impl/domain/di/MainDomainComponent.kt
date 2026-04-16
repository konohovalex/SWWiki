package ru.konohovalex.swwiki.feature.main.impl.domain.di

import dagger.Component
import ru.konohovalex.swwiki.feature.main.impl.domain.repository.api.TopicRepository

@Component(
    modules = [
        TopicRepositoryModule::class,
    ],
)
interface MainDomainComponent {
    fun topicRepository(): TopicRepository
}
