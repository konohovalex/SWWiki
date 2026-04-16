package ru.konohovalex.swwiki.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.TestImplementation
import ru.konohovalex.swwiki.utils.dependencies

class AndroidLifecycleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.dependencies(
            Implementation(LibraryNames.AndroidX.Lifecycle.Runtime.Ktx),
            Implementation(LibraryNames.AndroidX.Lifecycle.Runtime.Compose),
            TestImplementation(LibraryNames.AndroidX.Lifecycle.Runtime.Testing),
            Implementation(LibraryNames.AndroidX.Lifecycle.ViewModel.Ktx),
            Implementation(LibraryNames.AndroidX.Lifecycle.ViewModel.Compose),
            Implementation(LibraryNames.AndroidX.Lifecycle.ViewModel.Navigation3),
            TestImplementation(LibraryNames.AndroidX.Lifecycle.ViewModel.Testing),
        )
    }
}
