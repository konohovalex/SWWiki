import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
        freeCompilerArgs.addAll(
            "-Xcontext-parameters",
        )
    }
}

dependencies {
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.kotlin.ksp.gradle)
    compileOnly(libs.kotlin.compose.gradle)
    compileOnly(libs.android.gradle)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.androidx.room.gradle)
}

gradlePlugin {
    plugins {
        register("jvmLibrary") {
            id = libs.plugins.swwiki.jvm.library.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.JvmLibraryConventionPlugin"
        }
        register("kotlinCoroutines") {
            id = libs.plugins.swwiki.kotlin.coroutines.asProvider().get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.KotlinCoroutinesConventionPlugin"
        }
        register("kotlinCoroutinesAndroid") {
            id = libs.plugins.swwiki.kotlin.coroutines.android.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.KotlinCoroutinesAndroidConventionPlugin"
        }
        register("dagger") {
            id = libs.plugins.swwiki.dagger.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.DaggerConventionPlugin"
        }
        register("androidApplication") {
            id = libs.plugins.swwiki.android.application.asProvider().get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationFlavors") {
            id = libs.plugins.swwiki.android.application.flavors.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.swwiki.android.library.asProvider().get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidLibraryConventionPlugin"
        }
        register("androidFeatureApi") {
            id = libs.plugins.swwiki.android.feature.api.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidFeatureApiConventionPlugin"
        }
        register("androidFeatureImpl") {
            id = libs.plugins.swwiki.android.feature.impl.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidFeatureImplConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = libs.plugins.swwiki.android.application.compose.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.swwiki.android.library.compose.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLifecycle") {
            id = libs.plugins.swwiki.android.lifecycle.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidLifecycleConventionPlugin"
        }
        register("androidRoom") {
            id = libs.plugins.swwiki.android.room.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidRoomConventionPlugin"
        }
        register("androidTest") {
            id = libs.plugins.swwiki.android.test.get().pluginId
            implementationClass = "ru.konohovalex.swwiki.plugin.AndroidTestConventionPlugin"
        }
    }
}
