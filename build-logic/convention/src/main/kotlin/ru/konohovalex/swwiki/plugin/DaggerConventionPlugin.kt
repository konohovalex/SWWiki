package ru.konohovalex.swwiki.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.Ksp
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.plugins

class DaggerConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins(
                PluginName.Kotlin.KSP,
            )

            dependencies(
                Implementation(LibraryNames.Dagger.Core),
                Ksp(LibraryNames.Dagger.Compiler),
            )
        }
    }
}
