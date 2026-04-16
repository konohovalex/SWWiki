package ru.konohovalex.swwiki.feature.main.impl.domain.repository.impl

import ru.konohovalex.swwiki.feature.main.impl.domain.model.Topic
import ru.konohovalex.swwiki.feature.main.impl.domain.repository.api.TopicRepository
import javax.inject.Inject

internal class TopicRepositoryImpl
@Inject constructor() : TopicRepository {
    override fun getTopics(): List<Topic> =
        Topic.entries.toList()
}
