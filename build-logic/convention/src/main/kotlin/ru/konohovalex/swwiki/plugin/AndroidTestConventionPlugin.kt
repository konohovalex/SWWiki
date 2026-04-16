package ru.konohovalex.swwiki.plugin

import com.android.build.api.dsl.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.configureKotlinAndroid
import ru.konohovalex.swwiki.utils.plugins

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins(
                PluginName.Android.Test,
            )

            extensions.configure<TestExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 36
            }
        }
    }
}
