package ru.konohovalex.swwiki.feature.main.impl.presentation.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.konohovalex.swwiki.core.viewmodel.ViewModelKey
import ru.konohovalex.swwiki.feature.main.impl.presentation.viewmodel.MainScreenViewModel
import ru.konohovalex.swwiki.feature.main.impl.presentation.viewmodel.MainViewModel

@Module
internal abstract class MainViewModelModule {
    @[Binds IntoMap ViewModelKey(MainViewModel::class)]
    abstract fun bindMainViewModel(impl: MainViewModel): ViewModel

    @[Binds IntoMap ViewModelKey(MainScreenViewModel::class)]
    abstract fun bindMainScreenViewModel(impl: MainScreenViewModel): ViewModel
}
