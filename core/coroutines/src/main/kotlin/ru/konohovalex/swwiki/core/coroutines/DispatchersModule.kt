package ru.konohovalex.swwiki.core.coroutines

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.konohovalex.swwiki.core.di.qualifier.Default
import ru.konohovalex.swwiki.core.di.qualifier.Io
import ru.konohovalex.swwiki.core.di.qualifier.Main

@Module
object DispatchersModule {
    @[Provides Default]
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @[Provides Io]
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @[Provides Main]
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
