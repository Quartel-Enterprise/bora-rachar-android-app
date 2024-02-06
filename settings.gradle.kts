pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "BlitzSplit"

private val featureModules = listOf("login", "groups")
private val coreModules = listOf("theme", "navigation", "component")

private val allModules = featureModules.map { "feature:$it" } +
        coreModules.map { "core:$it" } +
        listOf("app")

allModules.forEach { module ->
    include(":$module")
}
include(":feature:groups")
include(":core:component")
include(":core:activity")
