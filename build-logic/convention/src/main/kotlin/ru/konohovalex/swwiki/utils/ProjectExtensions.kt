package ru.konohovalex.swwiki.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

fun Project.plugins(vararg names: PluginName) {
    names.forEach {
        apply(
            plugin = libs
                .findPlugin(it.versionCatalogName.versionCatalogNameToDependencyName()).get().get()
                .pluginId
        )
    }
}

@Suppress("UNCHECKED_CAST")
fun Project.dependencies(vararg values: Dependency) {
    dependencies {
        values.forEach { dependency ->
            val dependencyNotation = if (dependency.isBom) {
                platform(dependency.notation as Provider<MinimalExternalModuleDependency>)
            } else {
                dependency.notation
            }

            add(dependency.configurationName, dependencyNotation)
        }
    }
}
