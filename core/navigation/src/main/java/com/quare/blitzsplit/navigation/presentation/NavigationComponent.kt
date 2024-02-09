package com.quare.blitzsplit.navigation.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.blitzsplit.login.presentation.LoginScreen
import com.quare.blitzsplit.main.presentation.MainScreen
import com.quare.blitzsplit.navigation.utils.navigateDroppingAll

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.LOGIN
    ) {

        composable(Route.LOGIN) {
            LoginScreen(
                onNextScreen = {
                    navController.navigateDroppingAll(Route.MAIN)
                },
            )
        }

        composable(Route.MAIN) {
            MainScreen(
                backToLogin = { navController.navigateDroppingAll(Route.LOGIN) },
                splitBillClick = {}
            )
        }
    }
}
