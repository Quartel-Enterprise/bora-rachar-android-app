sealed class Module(val path: String) {

    sealed class Feature(featurePath: String) : Module("feature:$featurePath") {
        object Activities : Feature("activities")
        object Contacts : Feature("contacts")
        object CreateGroup : Feature("create_group")
        object Group : Feature("group")
        object Groups : Feature("groups")
        object Login : Feature("login")
        object Main : Feature("main")
    }

    sealed class Core(corePath: String) : Module("core:$corePath") {
        object Navigation : Core("navigation")
        object User : Core("user")
        object Utils : Core("utils")
    }

    sealed class Ui(uiPath: String) : Module("ui:$uiPath") {
        object Component : Ui("component")
        object Theme : Ui("theme")
    }
}
