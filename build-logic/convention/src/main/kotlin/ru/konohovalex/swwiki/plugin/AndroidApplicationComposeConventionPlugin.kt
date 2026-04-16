package ru.konohovalex.swwiki.plugin

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import ru.konohovalex.swwiki.utils.configureAndroidCompose

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configureAndroidCompose(target.extensions.getByType<ApplicationExtension>())
    }
}
