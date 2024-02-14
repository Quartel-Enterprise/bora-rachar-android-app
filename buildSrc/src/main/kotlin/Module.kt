sealed class Module(val path: String) {

    sealed class Feature(featurePath: String) : Module("feature:$featurePath") {
        object Activities : Feature("activities")
        object Contacts : Feature("contacts")
        object Group : Feature("group")
        object Groups : Feature("groups")
        object Login : Feature("login")
        object Main : Feature("main")
    }

    sealed class Core(corePath: String) : Module("core:$corePath") {
        object Component : Core("component")
        object Navigation : Core("navigation")
        object Theme : Core("theme")
        object User : Core("user")
        object Utils : Core("utils")
    }
}
