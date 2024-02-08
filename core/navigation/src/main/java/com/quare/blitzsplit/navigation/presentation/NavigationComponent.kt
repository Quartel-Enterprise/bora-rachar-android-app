package com.quare.blitzsplit.navigation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.blitzplit.component.navbar.BottomNavigationItem
import com.quare.blitzsplit.groups.ActivitiesScreen
import com.quare.blitzsplit.groups.ContactsScreen
import com.quare.blitzsplit.groups.GroupsScreen
import com.quare.blitzsplit.login.presentation.LoginScreen
import com.quare.blitzsplit.navigation.MainScreenData
import com.quare.blitzsplit.navigation.presentation.mainappbar.MainAppBarViewModel
import com.quare.blitzsplit.navigation.presentation.navbar.BottomNavBarViewModel
import com.quare.blitzsplit.navigation.utils.navigateDroppingAll

@Composable
fun NavigationComponent(
    mainAppBarViewModel: MainAppBarViewModel = hiltViewModel(),
    bottomBarViewModel: BottomNavBarViewModel = hiltViewModel(),
) {

    val navController = rememberNavController()
    val mainAppBarModel by mainAppBarViewModel.state.collectAsStateWithLifecycle()
    val bottomBarItems by bottomBarViewModel.state.collectAsStateWithLifecycle()

    val mainScreenData = MainScreenData(
        appBarModel = mainAppBarModel,
        navigationItems = bottomBarItems.map {
            BottomNavigationItem(
                title = it.title,
                icon = it.icon,
                isSelected = it.isSelected,
                onClick = {
                    bottomBarViewModel.onSelectItem(it)
                    navController.navigateDroppingAll(it.route)
                }
            )
        },
        callbacks = MainScreenCallbacks(
            onClickToPay = mainAppBarViewModel::onClickToPay,
            onClickToReceive = mainAppBarViewModel::onClickToReceive,
            onPhotoClick = {
                mainAppBarViewModel.onClickLogout()
                navController.navigateDroppingAll(Route.LOGIN)
            },
        )
    )

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
            MainScreen(mainScreenData) {
                GroupsScreen()
            }
        }

        composable(Route.CONTACTS) {
            MainScreen(mainScreenData) {
                ContactsScreen()
            }
        }

        composable(Route.ACTIVITY) {
            MainScreen(mainScreenData) {
                ActivitiesScreen()
            }
        }
    }
}
