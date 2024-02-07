package com.quare.blitzsplit.navigation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzplit.component.mainappbar.domain.PriceChipsModel
import com.quare.blitzsplit.groups.GroupsScreen
import com.quare.blitzsplit.groups.GroupsViewModel
import com.quare.blitzsplit.login.presentation.LoginScreen
import com.quare.blitzsplit.login.presentation.viewmodel.LoginViewModel

@Composable
fun NavigationComponent(
    loginViewModel: LoginViewModel = viewModel(),
) {

    val navController = rememberNavController()
    val loginState by loginViewModel.state.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(
                loginViewModel = loginViewModel,
                loginState = loginState,
                onNextScreen = {
                    navController.navigateDroppingAll("groups")
                },
            )
        }

        composable("groups") {
            val groupsViewModel = hiltViewModel<GroupsViewModel>()
            val userData by groupsViewModel.state.collectAsStateWithLifecycle()
            GroupsScreen(
                mainAppBarModel = MainAppBarModel(
                    photoUrl = userData?.profilePictureUrl,
                    priceChipsModel = PriceChipsModel(
                        toPay = "R$ 19.80",
                        toReceive = "R$ 250.00",
                    )
                ),
                onClickToPay = {},
                onClickToReceive = {},
                onPhotoClick = {
                    loginViewModel.onLogout()
                    navController.navigateDroppingAll("login")
                }
            )
        }
    }
}

private fun NavController.navigateDroppingAll(route: String) {
    navigate(route) {
        popUpTo(0)
    }
}
