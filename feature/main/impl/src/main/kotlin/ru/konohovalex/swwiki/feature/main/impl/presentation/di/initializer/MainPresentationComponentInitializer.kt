package ru.konohovalex.swwiki.feature.main.impl.presentation.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import ru.konohovalex.swwiki.core.viewmodel.di.IViewModelComponent
import ru.konohovalex.swwiki.feature.main.impl.domain.di.IMainDomainComponent
import ru.konohovalex.swwiki.feature.main.impl.presentation.di.DaggerMainPresentationComponent
import ru.konohovalex.swwiki.feature.main.impl.presentation.di.IMainPresentationComponent

class MainPresentationComponentInitializer(
    private val serviceLocator: ServiceLocator,
    private val mainDomainComponent: IMainDomainComponent,
    private val viewModelComponent: IViewModelComponent,
) : ComponentInitializer<IMainPresentationComponent> {
    override fun initialize(): IMainPresentationComponent {
        return DaggerMainPresentationComponent.builder()
            .serviceLocator(serviceLocator)
            .mainDomainComponent(mainDomainComponent)
            .build()
            .also {
                viewModelComponent.viewModelFactoryRegistry().apply {
                    it.viewModelsMap().forEach { entry ->
                        register(
                            entry.key,
                            entry.value
                        )
                    }
                }
            }
    }
}