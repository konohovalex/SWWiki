package ru.konohovalex.swwiki.core.viewmodel.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.viewmodel.DaggerViewModelFactory
import javax.inject.Singleton

@Module
internal interface FactoryModule {
    @Binds
    @Singleton
    fun bindSavedStateViewModelFactory(impl: DaggerViewModelFactory): ViewModelProvider.Factory
}
