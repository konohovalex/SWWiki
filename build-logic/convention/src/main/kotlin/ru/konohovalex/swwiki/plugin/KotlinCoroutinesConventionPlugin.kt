package ru.konohovalex.swwiki.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.TestImplementation
import ru.konohovalex.swwiki.utils.dependencies

class KotlinCoroutinesConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.dependencies(
            Implementation(LibraryNames.KotlinX.Coroutines.Core),
            TestImplementation(LibraryNames.KotlinX.Coroutines.Test),
        )
    }
}
