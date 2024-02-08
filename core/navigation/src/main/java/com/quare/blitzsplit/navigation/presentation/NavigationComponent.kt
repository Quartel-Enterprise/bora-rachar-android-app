package com.quare.blitzsplit.navigation.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.blitzsplit.groups.GroupsScreen
import com.quare.blitzsplit.login.presentation.LoginScreen
import com.quare.blitzsplit.navigation.presentation.mainappbar.MainAppBar
import com.quare.blitzsplit.navigation.utils.navigateDroppingAll

@Composable
fun NavigationComponent() {

    val navController = rememberNavController()

    val mainAppBarComposable = @Composable {
        MainAppBar(
            onLogout = {
                navController.navigateDroppingAll(Route.LOGIN)
            }
        )
    }

    NavHost(
        navController = navController,
        startDestination = Route.LOGIN
    ) {

        composable(Route.LOGIN) {
            LoginScreen(
                onNextScreen = {
                    navController.navigateDroppingAll(Route.GROUPS)
                },
            )
        }

        composable(Route.GROUPS) {
            GroupsScreen(mainAppBarComposable)
        }
    }
}
