pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "BlitzSplit"

private val modules = listOf("app", "login", "core:ui")

modules.forEach { module ->
    include(":$module")
}
