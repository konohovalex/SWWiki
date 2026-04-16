package ru.konohovalex.swwiki.plugin

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.plugins
import ru.konohovalex.swwiki.utils.configureKotlinAndroid

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins(PluginName.Android.Application)

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 36
                testOptions.animationsDisabled = true
            }
        }
    }
}
