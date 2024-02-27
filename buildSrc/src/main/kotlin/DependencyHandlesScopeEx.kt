import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.implementCore(vararg modules: Module.Core) {
    implementModules(*modules)
}

fun DependencyHandler.implementFeature(vararg modules: Module.Feature) {
    implementModules(*modules)
}

fun DependencyHandler.implementUi(vararg modules: Module.Ui) {
    implementModules(*modules)
}

internal fun DependencyHandler.implementModules(vararg modules: Module) {
    modules.forEach { module ->
        add("implementation", project(path = ":${module.path}"))
    }
}
