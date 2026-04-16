package ru.konohovalex.swwiki.feature.main.impl.presentation.di

import dagger.BindsInstance
import dagger.Component
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import ru.konohovalex.swwiki.feature.main.impl.domain.di.IMainDomainComponent

@Component(
    modules = [
        MainUiMapperModule::class,
        MainViewModelModule::class,
        NavigationModule::class,
    ],
    dependencies = [
        IMainDomainComponent::class,
    ],
)
internal interface MainPresentationComponent : IMainPresentationComponent {
    @Component.Builder
    interface Builder {
        fun serviceLocator(@BindsInstance serviceLocator: ServiceLocator): Builder

        fun mainDomainComponent(component: IMainDomainComponent): Builder

        fun build(): MainPresentationComponent
    }
}
