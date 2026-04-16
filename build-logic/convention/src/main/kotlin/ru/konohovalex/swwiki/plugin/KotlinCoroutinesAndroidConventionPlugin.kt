package ru.konohovalex.swwiki.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.plugins

class KotlinCoroutinesAndroidConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins(
                PluginName.SWWiki.Kotlin.Coroutines
            )
            dependencies(
                Implementation(LibraryNames.KotlinX.Coroutines.Android),
            )
        }
    }
}
