package com.quare.blitzsplit.navigation.utils

import androidx.navigation.NavController

fun NavController.navigateDroppingAll(route: String) {
    navigate(route = route) {
        popUpTo(graph.startDestinationId) { inclusive = true }
    }
    graph.setStartDestination(route)
}
