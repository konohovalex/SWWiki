package ru.konohovalex.swwiki.feature.main.impl.presentation.di

import dagger.Component
import ru.konohovalex.swwiki.feature.main.impl.domain.di.MainDomainComponent
import ru.konohovalex.swwiki.feature.main.impl.presentation.MainViewModel
import javax.inject.Provider

@Component(
    modules = [
        MainUiMapperModule::class,
        MainViewModelModule::class,
    ],
    dependencies = [
        MainDomainComponent::class,
    ],
)
interface MainPresentationComponent {
    fun mainViewModelProvider(): Provider<MainViewModel>

    @Component.Builder
    interface Builder {
        fun mainDomainComponent(component: MainDomainComponent): Builder

        fun build(): MainPresentationComponent
    }
}
