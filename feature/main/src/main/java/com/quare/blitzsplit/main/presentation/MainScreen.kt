package com.quare.blitzsplit.main.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quare.blitzplit.component.mainappbar.presentaiton.MainAppBarComponent
import com.quare.blitzplit.component.navbar.BottomNavBarComponent
import com.quare.blitzplit.component.splitbill.SplitBillButton
import com.quare.blitzsplit.activities.presentation.ActivitiesScreen
import com.quare.blitzsplit.contacts.ContactsScreen
import com.quare.blitzsplit.groups.presentation.GroupsScreen
import com.quare.blitzsplit.main.domain.model.MainScreenCallbacks
import com.quare.blitzsplit.main.presentation.component.mainappbar.MainAppBarViewModel
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavBarViewModel
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavScreen

@Composable
fun MainScreen(
    callbacks: MainScreenCallbacks,
    mainAppBarViewModel: MainAppBarViewModel = hiltViewModel(),
    bottomBarViewModel: BottomNavBarViewModel = hiltViewModel(),
) {
    val mainAppBarModel by mainAppBarViewModel.state.collectAsStateWithLifecycle()
    val bottomBarState by bottomBarViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            MainAppBarComponent(
                data = mainAppBarModel,
                onClickToPay = mainAppBarViewModel::onClickToPay,
                onClickToReceive = mainAppBarViewModel::onClickToReceive,
                onPhotoClick = {
                    mainAppBarViewModel.onClickLogout()
                    callbacks.backToLogin()
                }
            )
        },
        floatingActionButton = {
            SplitBillButton(onClick = callbacks.splitBillClick)
        },
        bottomBar = {
            BottomNavBarComponent(bottomBarState.items)
        }
    ) { paddingValues ->
        val modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        when (bottomBarState.selectedScreen) {
            BottomNavScreen.GROUPS -> GroupsScreen(
                modifier = modifier,
                createGroupClick = callbacks.createGroupClick
            )
            BottomNavScreen.CONTACTS -> ContactsScreen(modifier)
            BottomNavScreen.ACTIVITY -> ActivitiesScreen(modifier)
        }
    }
}
