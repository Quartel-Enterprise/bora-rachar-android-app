pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "Blitz Split"

private val featureModules = listOf(
    "activities",
    "contacts",
    "group",
    "groups",
    "login",
    "main"
)

private val coreModules = listOf(
    "navigation",
    "user",
    "utils"
)

private val uiModules = listOf(
    "component",
    "theme",
)

private val allModules = featureModules.map { "feature:$it" } +
        coreModules.map { "core:$it" } + uiModules.map { "ui:$it" } +
        listOf("app")

allModules.forEach { module ->
    include(":$module")
}
include(":ui")
