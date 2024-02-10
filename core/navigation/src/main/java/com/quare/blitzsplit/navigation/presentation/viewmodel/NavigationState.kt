package com.quare.blitzsplit.navigation.presentation.viewmodel

import com.quare.blitzsplit.navigation.domain.model.Route

sealed class NavigationState(val route: String) {

    data object Loading : NavigationState(Route.LOADING_NAVIGATION)
    sealed class Loaded(route: String) : NavigationState(route) {
        data object LoggedIn : Loaded(Route.MAIN)
        data object LoggedOut : Loaded(Route.LOGIN)
    }
}
