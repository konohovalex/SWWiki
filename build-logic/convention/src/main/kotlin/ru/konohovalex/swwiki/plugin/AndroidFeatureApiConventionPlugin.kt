package ru.konohovalex.swwiki.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.plugins


class AndroidFeatureApiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins(
                PluginName.Kotlin.Serialization,
                PluginName.SWWiki.Android.Library,
            )

            dependencies(
                Implementation(LibraryNames.KotlinX.SerializationJson),
                Implementation(LibraryNames.KotlinX.DateTime),
            )
        }
    }
}
