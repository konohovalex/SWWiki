package ru.konohovalex.swwiki.core.network.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
    ]
)
internal interface NetworkComponent : INetworkComponent
