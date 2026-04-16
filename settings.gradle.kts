pluginManagement {
    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "swwiki"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")

include(":core:cache")
include(":core:coroutines")
include(":core:database")
//include(":core:design")
include(":core:di")
include(":core:functional")
include(":core:navigation")
include(":core:network")
include(":core:servicelocator")
include(":core:ui")
include(":core:viewmodel")

include(":feature:main:api")
include(":feature:main:impl")

include(":feature:character:common:data:api")
include(":feature:character:common:data:impl")
include(":feature:character:common:domain:api")
include(":feature:character:details:domain:api")
include(":feature:character:details:domain:impl")
include(":feature:character:details:presentation:api")
include(":feature:character:details:presentation:impl")
include(":feature:character:search:domain:api")
include(":feature:character:search:domain:impl")
include(":feature:character:search:presentation:api")
include(":feature:character:search:presentation:impl")

include(":feature:film:common:data:api")
include(":feature:film:common:data:impl")
include(":feature:film:common:domain:api")
include(":feature:film:details:domain:api")
include(":feature:film:details:domain:impl")
include(":feature:film:details:presentation:api")
include(":feature:film:details:presentation:impl")
include(":feature:film:search:domain:api")
include(":feature:film:search:domain:impl")
include(":feature:film:search:presentation:api")
include(":feature:film:search:presentation:impl")

include(":feature:planet:common:data:api")
include(":feature:planet:common:data:impl")
include(":feature:planet:common:domain:api")
include(":feature:planet:details:domain:api")
include(":feature:planet:details:domain:impl")
include(":feature:planet:details:presentation:api")
include(":feature:planet:details:presentation:impl")
include(":feature:planet:search:domain:api")
include(":feature:planet:search:domain:impl")
include(":feature:planet:search:presentation:api")
include(":feature:planet:search:presentation:impl")

include(":feature:specie:common:data:api")
include(":feature:specie:common:data:impl")
include(":feature:specie:common:domain:api")
include(":feature:specie:details:domain:api")
include(":feature:specie:details:domain:impl")
include(":feature:specie:details:presentation:api")
include(":feature:specie:details:presentation:impl")
include(":feature:specie:search:domain:api")
include(":feature:specie:search:domain:impl")
include(":feature:specie:search:presentation:api")
include(":feature:specie:search:presentation:impl")

include(":feature:starship:common:data:api")
include(":feature:starship:common:data:impl")
include(":feature:starship:common:domain:api")
include(":feature:starship:details:domain:api")
include(":feature:starship:details:domain:impl")
include(":feature:starship:details:presentation:api")
include(":feature:starship:details:presentation:impl")
include(":feature:starship:search:domain:api")
include(":feature:starship:search:domain:impl")
include(":feature:starship:search:presentation:api")
include(":feature:starship:search:presentation:impl")

include(":feature:vehicle:common:data:api")
include(":feature:vehicle:common:data:impl")
include(":feature:vehicle:common:domain:api")
include(":feature:vehicle:details:domain:api")
include(":feature:vehicle:details:domain:impl")
include(":feature:vehicle:details:presentation:api")
include(":feature:vehicle:details:presentation:impl")
include(":feature:vehicle:search:domain:api")
include(":feature:vehicle:search:domain:impl")
include(":feature:vehicle:search:presentation:api")
include(":feature:vehicle:search:presentation:impl")
