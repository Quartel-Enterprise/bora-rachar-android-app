pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "BlitzSplit"

private val featureModules = listOf(
    "activities",
    "contacts",
    "group",
    "groups",
    "login",
    "main"
)
private val coreModules = listOf(
    "component",
    "navigation",
    "theme",
    "user",
    "utils"
)

private val allModules = featureModules.map { "feature:$it" } +
        coreModules.map { "core:$it" } +
        listOf("app")

allModules.forEach { module ->
    include(":$module")
}
