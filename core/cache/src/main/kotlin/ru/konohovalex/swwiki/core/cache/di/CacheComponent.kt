package ru.konohovalex.swwiki.core.cache.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CacheModule::class,
    ],
)
internal interface CacheComponent : ICacheComponent
