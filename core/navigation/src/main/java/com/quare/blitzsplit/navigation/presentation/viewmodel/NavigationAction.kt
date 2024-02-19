package com.quare.blitzsplit.navigation.presentation.viewmodel

sealed interface NavigationAction {
    data class NavigateToGroupDetails(val route: String): NavigationAction
}
