package ru.konohovalex.swwiki.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.TestImplementation
import ru.konohovalex.swwiki.utils.configureKotlinJvm
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.plugins

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins(
                PluginName.Kotlin.JVM,
            )

            configureKotlinJvm()

            dependencies(
                TestImplementation(LibraryNames.Kotlin.Test),
            )
        }
    }
}
