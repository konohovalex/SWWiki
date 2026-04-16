package ru.konohovalex.swwiki.plugin

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import ru.konohovalex.swwiki.utils.configureAndroidCompose

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configureAndroidCompose(target.extensions.getByType<LibraryExtension>())
    }
}
