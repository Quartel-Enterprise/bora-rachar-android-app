pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "BlitzSplit"

val modules = listOf("app", "login", "core")

modules.forEach { module ->
    include(":$module")
}
include(":core:ui")
