package ru.konohovalex.swwiki

import android.app.Application
import ru.konohovalex.swwiki.core.cache.di.CacheComponent
import ru.konohovalex.swwiki.core.cache.di.DaggerCacheComponent
import ru.konohovalex.swwiki.core.database.di.DaggerDatabaseComponent
import ru.konohovalex.swwiki.core.database.di.DatabaseComponent
import ru.konohovalex.swwiki.core.navigation.di.DaggerNavigationComponent
import ru.konohovalex.swwiki.core.navigation.di.NavigationComponent
import ru.konohovalex.swwiki.core.network.di.DaggerNetworkComponent
import ru.konohovalex.swwiki.core.network.di.NetworkComponent
import ru.konohovalex.swwiki.core.servicelocator.MapRegistryServiceLocator
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import ru.konohovalex.swwiki.core.servicelocator.registry.MapRegistryBuilder
import ru.konohovalex.swwiki.core.viewmodel.di.DaggerViewModelComponent
import ru.konohovalex.swwiki.core.viewmodel.di.ViewModelComponent
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
            .bind(CacheComponent::class) {
                DaggerCacheComponent.create()
            }
            .bind(DatabaseComponent::class) {
                DaggerDatabaseComponent.builder()
                    .applicationContext(this@SWWikiApp)
                    .build()
            }
            .bind(NavigationComponent::class) {
                DaggerNavigationComponent.create()
            }
            .bind(NetworkComponent::class) {
                DaggerNetworkComponent.create()
            }
            .bind(ViewModelComponent::class) {
                DaggerViewModelComponent.create()
            }
            .build()
    }

    override fun <T : Any> get(clazz: KClass<T>): T = serviceLocator.get(clazz)
}
