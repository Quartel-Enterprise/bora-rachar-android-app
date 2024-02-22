package com.quare.blitzsplit.navigation.presentation

import presentaiton.GroupScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.blitzsplit.login.presentation.LoginScreen
import com.quare.blitzsplit.main.domain.model.MainScreenCallbacks
import com.quare.blitzsplit.main.presentation.MainScreen
import com.quare.blitzsplit.navigation.domain.model.Route
import com.quare.blitzsplit.navigation.presentation.viewmodel.NavigationAction
import com.quare.blitzsplit.navigation.presentation.viewmodel.NavigationViewModel
import com.quare.blitzsplit.navigation.utils.navigateDroppingAll
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NavigationComponent(
    viewModel: NavigationViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.action.collectLatest { action ->
            when (action) {
                is NavigationAction.NavigateToGroupDetails -> navController.navigate(action.route)
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = state.route
    ) {

        composable(Route.LOADING_NAVIGATION) {
            Log.d("NavigationComponent", "Loading navigation...")
        }

        composable(Route.LOGIN) {
            LoginScreen(
                onNextScreen = {
                    navController.navigateDroppingAll(Route.MAIN)
                },
            )
        }

        composable(Route.MAIN) {
            MainScreen(
                callbacks = MainScreenCallbacks(
                    backToLogin = { navController.navigateDroppingAll(Route.LOGIN) },
                    splitBillClick = {},
                    createGroupClick = {},
                    onGroupClick = viewModel::onGroupClick
                )
            )
        }

        composable("${Route.GROUP}/{groupId}") {
            GroupScreen(
                onBack = navController::popBackStack
            )
        }
    }
}
