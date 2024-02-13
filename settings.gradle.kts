pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "BlitzSplit"

private val featureModules = listOf("activities", "contacts", "login", "group", "groups", "main")
private val coreModules = listOf("theme", "navigation", "component", "user", "utils")

private val allModules = featureModules.map { "feature:$it" } +
        coreModules.map { "core:$it" } +
        listOf("app")

allModules.forEach { module ->
    include(":$module")
}
