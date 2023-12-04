pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
rootProject.name = "BlitzSplit"

val modules = listOf("app", "login")

modules.forEach { module ->
    include(":$module")
}
