import ru.konohovalex.swwiki.utils.Api
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.SWWikiBuildType
import ru.konohovalex.swwiki.utils.dependencies

plugins {
    alias(libs.plugins.swwiki.android.application)
    alias(libs.plugins.swwiki.android.application.flavors)
}

android {
    namespace = "ru.konohovalex.swwiki"

    defaultConfig {
        applicationId = "ru.konohovalex.swwiki"

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = SWWikiBuildType.DEBUG.applicationIdSuffix

            isMinifyEnabled = false
        }
        release {
            applicationIdSuffix = SWWikiBuildType.RELEASE.applicationIdSuffix

            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies(
    Implementation(projects.core.cache),
    Implementation(projects.core.database),
    Implementation(projects.core.navigation),
    Implementation(projects.core.network),
    Implementation(projects.core.servicelocator),
    Implementation(projects.core.viewmodel),

    Api(projects.feature.main.impl),
)
