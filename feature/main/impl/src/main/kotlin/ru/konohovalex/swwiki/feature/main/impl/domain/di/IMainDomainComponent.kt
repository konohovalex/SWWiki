package ru.konohovalex.swwiki.feature.main.impl.domain.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.main.impl.domain.repository.api.TopicRepository

interface IMainDomainComponent : IComponent {
    fun topicRepository(): TopicRepository
}
