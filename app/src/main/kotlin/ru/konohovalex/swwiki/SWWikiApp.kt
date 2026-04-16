package ru.konohovalex.swwiki

import android.app.Application
import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.cache.di.initializer.CacheComponentInitializer
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.database.di.initializer.DatabaseComponentInitializer
import ru.konohovalex.swwiki.core.navigation.di.INavigationComponent
import ru.konohovalex.swwiki.core.navigation.di.initializer.NavigationComponentInitializer
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.core.network.di.initializer.NetworkComponentInitializer
import ru.konohovalex.swwiki.core.servicelocator.MapRegistryServiceLocator
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import ru.konohovalex.swwiki.core.servicelocator.registry.MapRegistryBuilder
import ru.konohovalex.swwiki.core.viewmodel.di.IViewModelComponent
import ru.konohovalex.swwiki.core.viewmodel.di.initializer.ViewModelComponentInitializer
import kotlin.reflect.KClass

// TODO(clean everything up: unnecessary entities, libs, modules, plugins, tests dirs, etc.)
// TODO(splash screen)
// TODO(swipe-to-refresh)
// TODO(build files with correct dependency types - try to reduce amount of api() Gradle dependencies between features)
// TODO(LAZY!!!)
// TODO(SCOPES + Singleton => AppScope)
// TODO(check data classes, which should not be data classes)
// TODO(tests: Unit, UI)
class SWWikiApp : Application(), ServiceLocator {
    private lateinit var serviceLocator: MapRegistryServiceLocator

    override fun onCreate() {
        super.onCreate()

        serviceLocator = MapRegistryBuilder()
            .bind(ICacheComponent::class) {
                CacheComponentInitializer().initialize()
            }
            .bind(IDatabaseComponent::class) {
                DatabaseComponentInitializer(this@SWWikiApp).initialize()
            }
            .bind(INavigationComponent::class) {
                NavigationComponentInitializer().initialize()
            }
            .bind(INetworkComponent::class) {
                NetworkComponentInitializer().initialize()
            }
            .bind(IViewModelComponent::class) {
                ViewModelComponentInitializer().initialize()
            }
            .build()
    }

    override fun <T : Any> get(clazz: KClass<T>): T = serviceLocator.get(clazz)
}
