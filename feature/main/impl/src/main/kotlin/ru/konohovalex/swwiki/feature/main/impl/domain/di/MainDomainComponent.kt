package ru.konohovalex.swwiki.feature.main.impl.domain.di

import dagger.Component

@Component(
    modules = [
        TopicRepositoryModule::class,
    ],
)
internal interface MainDomainComponent : IMainDomainComponent
