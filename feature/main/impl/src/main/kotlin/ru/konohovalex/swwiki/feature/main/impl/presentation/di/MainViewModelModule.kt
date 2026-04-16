package ru.konohovalex.swwiki.feature.main.impl.presentation.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.feature.main.impl.presentation.MainViewModel

@Module
internal interface MainViewModelModule {
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel
}
