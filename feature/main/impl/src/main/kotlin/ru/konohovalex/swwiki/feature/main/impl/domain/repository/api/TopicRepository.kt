package ru.konohovalex.swwiki.feature.main.impl.domain.repository.api

import ru.konohovalex.swwiki.feature.main.impl.domain.model.Topic

interface TopicRepository {
    fun getTopics(): List<Topic>
}
